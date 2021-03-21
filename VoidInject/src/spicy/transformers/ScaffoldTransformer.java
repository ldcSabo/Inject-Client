package spicy.transformers;

import java.util.List;

import spicy.ClassNames;
import spicy.Injector;
import voidutilities.ClassReader;
import voidutilities.tree.AbstractInsnNode;
import voidutilities.tree.ClassNode;
import voidutilities.tree.FieldInsnNode;
import voidutilities.tree.InsnList;
import voidutilities.tree.MethodInsnNode;
import voidutilities.tree.MethodNode;
import voidutilities.tree.TypeInsnNode;
import voidutilities.tree.VarInsnNode;

public class ScaffoldTransformer extends Injector {

	boolean bikere = false;

	/*
	 * Entity classı
	 */
	@Override
	public void inject(ClassReader classReader, ClassNode classNode) {
		for (MethodNode methodNode : (List<MethodNode>) classNode.methods) {
			if ((classNode.name.contains(ClassNames.getNameIndex(ClassNames.entity))
					&& methodNode.name.equals(ClassNames.moveEntity)) && methodNode.desc.equals("(DDD)V")) { // MoveEntity

				AbstractInsnNode target2 = null;
				AbstractInsnNode todelete = null;
				for (AbstractInsnNode codes : methodNode.instructions.toArray()) {
					if (codes.getOpcode() == F_NEW && codes.getNext().getOpcode() == ISTORE
							&& ((VarInsnNode) codes.getNext()).var == 20
							&& codes.getNext().getNext().getOpcode() == ILOAD
							&& ((VarInsnNode) codes.getNext().getNext()).var == 20
							&& codes.getNext().getNext().getNext().getOpcode() == IFEQ) {
						target2 = codes.getNext();
						todelete = codes.getNext().getNext();
						break;
					}
				}

				methodNode.instructions.remove(todelete);

				InsnList insertMove = new InsnList();
				insertMove.add(new MethodInsnNode(INVOKESTATIC, "joptsimple/internal/dev/sabo/utils/EntityUtils", "onMove", "()V", false));
				methodNode.instructions.insert(insertMove);

				InsnList toinsert = new InsnList();

				toinsert.add(new VarInsnNode(ALOAD, 0));
				toinsert.add(new FieldInsnNode(GETFIELD, ClassNames.entity, ClassNames.onground, "Z"));// onground
				toinsert.add(new VarInsnNode(ALOAD, 0));
				toinsert.add(new MethodInsnNode(INVOKEVIRTUAL, ClassNames.entity, ClassNames.isSneaking, "()Z", false));// issneaking
				toinsert.add(new VarInsnNode(ALOAD, 0));
				toinsert.add(new TypeInsnNode(INSTANCEOF, ClassNames.entityplayersp));
				toinsert.add(new MethodInsnNode(INVOKESTATIC, "joptsimple/internal/dev/sabo/module/mods/Scaffold", "checkStats", "(ZZZ)Z",
						false));// instanceof entityplayersp
				methodNode.instructions.insert(target2, toinsert);

			}
			if ((classNode.name.contains("Scaffold") && methodNode.name.equals("data"))
					&& methodNode.desc.equals("(Lnet/minecraft/BlockPos;III)L" + ClassNames.block + ";")) {
				AbstractInsnNode areturn = null;

				for (AbstractInsnNode abs : methodNode.instructions.toArray()) {
					if (abs.getOpcode() == ARETURN) {
						areturn = abs;
					}
				}

				methodNode.instructions.remove(areturn.getPrevious());

				InsnList insert = new InsnList();

				insert.add(new MethodInsnNode(INVOKESTATIC, "joptsimple/internal/dev/sabo/utils/TransformerHelper", "mc",
						"()" + ClassNames.getDesc(ClassNames.minecraft), false));
				insert.add(new FieldInsnNode(GETFIELD, ClassNames.minecraft, ClassNames.theWorld,
						ClassNames.getDesc(ClassNames.worldclient))); // theWorld
				insert.add(new VarInsnNode(ALOAD, 1));
				insert.add(new VarInsnNode(ILOAD, 2));
				insert.add(new VarInsnNode(ILOAD, 3));
				insert.add(new VarInsnNode(ILOAD, 4));
				insert.add(new MethodInsnNode(INVOKEVIRTUAL, "net/minecraft/BlockPos", ClassNames.add,
						"(III)Lnet/minecraft/BlockPos;", false));// BlockPosdaki add methodu
				insert.add(new MethodInsnNode(INVOKEVIRTUAL, ClassNames.worldclient, ClassNames.getBlockState,
						"(Lnet/minecraft/BlockPos;)" + ClassNames.getDesc(ClassNames.iblockstate), false));// getBlockState
																											// world
																											// classındaki
				insert.add(new MethodInsnNode(INVOKEINTERFACE, ClassNames.iblockstate, ClassNames.getBlock,
						"()" + ClassNames.getDesc(ClassNames.block), true));// getBlock
				methodNode.instructions.insertBefore(areturn, insert);
			}
			if ((classNode.name.contains(ClassNames.getNameIndex(ClassNames.entityplayer))
					&& methodNode.name.equals(ClassNames.getHeldItem))
					&& methodNode.desc.equals("()" + ClassNames.getDesc(ClassNames.itemstack))) {// entityplayerdeki
																									// helditem methodu
				AbstractInsnNode areturn = null;

				/*
				 * public String b() { --> getName() return this.bP.getName(); }
				 * 
				 * public Q a() { return this.cg; }
				 * 
				 * public qz a(int var1) { return this.bV.b(); }
				 * 
				 * public qz a() { --> BURASI return this.bV.b(); }
				 * 
				 * public void b(int var1, qz var2) { this.bV.b[var1] = var2; }
				 * 
				 */

				for (AbstractInsnNode abs : methodNode.instructions.toArray()) {
					if (abs.getOpcode() == ALOAD) {
						areturn = abs;
						break;
					}
				}

				InsnList insnList = new InsnList();
				insnList.add(new VarInsnNode(ALOAD, 0));
				insnList.add(new FieldInsnNode(GETFIELD, ClassNames.entityplayer, ClassNames.inventory,
						ClassNames.getDesc(ClassNames.inventoryplayer)));// entityplayerdeki inventory fieldı
				insnList.add(new MethodInsnNode(INVOKEVIRTUAL, ClassNames.inventoryplayer, ClassNames.getCurrentItem,
						"()" + ClassNames.getDesc(ClassNames.itemstack), false));// inventoryplayerdeki getcurrentitem
																					// methodu
				insnList.add(new MethodInsnNode(INVOKESTATIC, "joptsimple/internal/dev/sabo/module/mods/Scaffold", "putfield",
						"(" + ClassNames.getDesc(ClassNames.itemstack) + ")V", false));
				methodNode.instructions.insertBefore(areturn, insnList);
			}
		}
	}
}
