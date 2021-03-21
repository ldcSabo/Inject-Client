package spicy.transformers;

import java.util.List;

import spicy.ClassNames;
import spicy.Injector;
import voidutilities.ClassReader;
import voidutilities.tree.AbstractInsnNode;
import voidutilities.tree.ClassNode;
import voidutilities.tree.FieldInsnNode;
import voidutilities.tree.InsnList;
import voidutilities.tree.InsnNode;
import voidutilities.tree.JumpInsnNode;
import voidutilities.tree.LabelNode;
import voidutilities.tree.MethodInsnNode;
import voidutilities.tree.MethodNode;
import voidutilities.tree.VarInsnNode;

public class PlayerControllerTransformer extends Injector {

	public int control = 0;
	public int controlreturn = 0;
	public boolean doonce = false;

	@Override
	public void inject(ClassReader classReader, ClassNode classNode) {
		for (MethodNode methodNode : (List<MethodNode>) classNode.methods) {
			if ((classNode.name.contains(ClassNames.getNameIndex(ClassNames.playercontrollermp))
					&& methodNode.name.equals(ClassNames.func_180512_c))
					&& methodNode.desc.equals("(Lnet/minecraft/BlockPos;L" + ClassNames.enumfacing + ";)Z")) {
				InsnList insnList2 = new InsnList();
				insnList2.add(new VarInsnNode(ALOAD, 0));
				insnList2.add(new InsnNode(FCONST_1));// curblock damage i 1 yap�yor
				insnList2.add(
						new FieldInsnNode(PUTFIELD, ClassNames.playercontrollermp, ClassNames.curBlockDamageMP, "F"));
				insnList2.add(new VarInsnNode(ALOAD, 0));
				insnList2.add(new InsnNode(ICONST_0));// block hit delay� 0 yap�yor
				insnList2
						.add(new FieldInsnNode(PUTFIELD, ClassNames.playercontrollermp, ClassNames.blockHitDelay, "I"));
				methodNode.instructions.insert(insnList2);

				AbstractInsnNode ainsnList = null;

				for (AbstractInsnNode abs : methodNode.instructions.toArray()) {
					if (abs.getOpcode() == ALOAD) {
						if (((VarInsnNode) abs).var == 0 && abs.getNext().getOpcode() == FCONST_1) {
							ainsnList = abs;
							break;
						}
					}
				}
				AbstractInsnNode ifcondi = ainsnList;

				for (int i = 0; i < 5; ++i) {
					ifcondi = ifcondi.getNext();
				}

				InsnList insnList = new InsnList();
				LabelNode lb = new LabelNode();
				insnList.add(
						new MethodInsnNode(INVOKESTATIC, "joptsimple/internal/dev/sabo/module/mods/SpeedMine", "isEnabled", "()Z", false));
				insnList.add(new JumpInsnNode(IFEQ, lb));

				methodNode.instructions.insertBefore(ainsnList, insnList);
				methodNode.instructions.insert(ifcondi, lb);

			}
		}
	}
}