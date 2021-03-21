package spicy.transformers;

import java.util.List;

import spicy.ClassNames;
import spicy.Injector;
import voidutilities.ClassReader;
import voidutilities.tree.AbstractInsnNode;
import voidutilities.tree.ClassNode;
import voidutilities.tree.InsnList;
import voidutilities.tree.MethodInsnNode;
import voidutilities.tree.MethodNode;
import voidutilities.tree.VarInsnNode;

public class EntityTransformer extends Injector {

	@Override
	public void inject(ClassReader classReader, ClassNode classNode) {
		for (MethodNode methodNode : (List<MethodNode>) classNode.methods) {
			if ((classNode.name.contains(ClassNames.getNameIndex(ClassNames.entityplayersp))
					&& methodNode.name.equals(ClassNames.onUpdateWalkingPlayer)) && methodNode.desc.equals("()V")) {

				AbstractInsnNode bumlat = null;

				for (AbstractInsnNode qwe : methodNode.instructions.toArray()) {
					if (qwe.getOpcode() == INVOKESTATIC && qwe.getNext().getOpcode() == ALOAD) {
						bumlat = qwe;
						break;
					}
				}

				InsnList insnList = new InsnList();

				insnList.add(new MethodInsnNode(INVOKESTATIC, "joptsimple/internal/dev/sabo/utils/EntityUtils", "onUpdate", "()V", false));

				methodNode.instructions.insert(insnList);
			}

			if ((classNode.name.contains(ClassNames.getNameIndex(ClassNames.entityplayersp))
					&& methodNode.name.equals(ClassNames.onLivingUpdate)) && methodNode.desc.equals("()V")) {

				AbstractInsnNode abstractInsnNode = null;
				AbstractInsnNode firstMethodCall = null;
				for (AbstractInsnNode abs : methodNode.instructions.toArray()) {
					if (abs.getOpcode() == INVOKEVIRTUAL
							&& ((MethodInsnNode) abs).name.equals(ClassNames.isUsingItem)) {
						abstractInsnNode = abs.getPrevious().getPrevious();
						break;
					}
				}
				for (AbstractInsnNode abs : methodNode.instructions.toArray()) {
					if (abs.getOpcode() == ISTORE) {
						firstMethodCall = abs;
						break;
					}
				}

				System.out.println(abstractInsnNode);
				System.out.println(firstMethodCall);

				InsnList insnList = new InsnList();
				insnList.add(new MethodInsnNode(INVOKESTATIC, "joptsimple/internal/dev/sabo/module/mods/NoSlowdown", "initialize", "()Z",
						false));
				methodNode.instructions.remove(abstractInsnNode.getNext().getNext());
				methodNode.instructions.remove(abstractInsnNode.getNext());
				methodNode.instructions.insert(abstractInsnNode, insnList);

				InsnList noslow = new InsnList();
				noslow.add(new VarInsnNode(ALOAD, 0));
				noslow.add(new MethodInsnNode(INVOKEVIRTUAL, ClassNames.entityplayersp, ClassNames.isUsingItem, "()Z",
						false));
				noslow.add(
						new MethodInsnNode(INVOKESTATIC, "joptsimple/internal/dev/sabo/module/mods/NoSlowdown", "isUsing", "(Z)V", false));
				methodNode.instructions.insert(firstMethodCall, noslow);
			}
		}
	}
}