package spicy.transformers;

import java.util.List;

import spicy.ClassNames;
import spicy.Injector;
import voidutilities.ClassReader;
import voidutilities.tree.AbstractInsnNode;
import voidutilities.tree.ClassNode;
import voidutilities.tree.InsnList;
import voidutilities.tree.InsnNode;
import voidutilities.tree.MethodInsnNode;
import voidutilities.tree.MethodNode;
import voidutilities.tree.VarInsnNode;

public class ReachTransformer extends Injector {

	@Override
	public void inject(ClassReader classReader, ClassNode classNode) {
		for (MethodNode methodNode : (List<MethodNode>) classNode.methods) {
			if ((methodNode.name.equals(ClassNames.getMouseOver)
					&& classNode.name.contains(ClassNames.getNameIndex(ClassNames.entityrenderer)))
					&& methodNode.desc.equals("(F)V"))// entityrenderer getMouseOver methodu
			{
				AbstractInsnNode zan = null;

				for (AbstractInsnNode qwe : methodNode.instructions.toArray()) {
					if (qwe.getOpcode() == ALOAD && qwe.getNext().getOpcode() == GETFIELD
							&& qwe.getNext().getNext().getOpcode() == ALOAD
							&& qwe.getNext().getNext().getNext().getOpcode() == DLOAD
							&& qwe.getNext().getNext().getNext().getNext().getOpcode() == FLOAD
							&& qwe.getNext().getNext().getNext().getNext().getNext().getOpcode() == INVOKEVIRTUAL) {
						zan = qwe.getNext().getNext();
						break;
					}
				}

				methodNode.instructions.remove(zan.getNext());

				InsnList reach = new InsnList();

				// reach.add(new LdcInsnNode(new Float("7.0")));

				reach.add(new MethodInsnNode(INVOKESTATIC, "joptsimple/internal/dev/sabo/module/mods/Reach", "getValue", "()D", false));

				methodNode.instructions.insert(zan, reach);

				AbstractInsnNode controlremove = null;

				for (AbstractInsnNode qwe : methodNode.instructions.toArray()) {
					if (qwe.getOpcode() == F_NEW && qwe.getNext().getOpcode() == ICONST_1) {
						controlremove = qwe;
						break;
					}
				}

				methodNode.instructions.remove(controlremove.getNext());

				InsnList controlnext = new InsnList();

				controlnext.add(new InsnNode(ICONST_0));

				methodNode.instructions.insert(controlremove, controlnext);

				AbstractInsnNode zan1 = null;

				AbstractInsnNode zan2 = null;

				AbstractInsnNode zan3 = null;

				for (AbstractInsnNode qwe : methodNode.instructions.toArray()) {
					if (qwe.getOpcode() == F_NEW && qwe.getNext().getOpcode() == ALOAD
							&& qwe.getNext().getNext().getOpcode() == FLOAD
							&& qwe.getNext().getNext().getNext().getOpcode() == INVOKEVIRTUAL
							&& qwe.getNext().getNext().getNext().getNext().getOpcode() == ASTORE
							&& ((VarInsnNode) qwe.getNext().getNext().getNext().getNext()).var == 11) {
						zan1 = qwe.getNext().getNext().getNext().getNext().getNext().getNext().getNext();// 1. getfield
						zan2 = zan1.getNext().getNext().getNext().getNext();// 2. getfield
						zan3 = zan2.getNext().getNext().getNext().getNext(); // 3. getfield
						break;
					}
				}
				methodNode.instructions.remove(zan1.getNext());
				methodNode.instructions.remove(zan2.getNext());
				methodNode.instructions.remove(zan3.getNext());
				AbstractInsnNode zan11 = null;

				AbstractInsnNode zan22 = null;

				AbstractInsnNode zan33 = null;

				for (AbstractInsnNode qwe : methodNode.instructions.toArray()) {
					if (qwe.getOpcode() == ALOAD && qwe.getNext().getOpcode() == ALOAD
							&& qwe.getNext().getNext().getOpcode() == INVOKEVIRTUAL
							&& qwe.getNext().getNext().getNext().getOpcode() == ALOAD
							&& ((VarInsnNode) qwe.getNext().getNext().getNext()).var == 11
							&& qwe.getNext().getNext().getNext().getNext().getOpcode() == GETFIELD) {
						zan11 = qwe.getNext().getNext().getNext().getNext();// 1. getfield
						zan22 = zan11.getNext().getNext().getNext().getNext();// 2. getfield
						zan33 = zan22.getNext().getNext().getNext().getNext(); // 3. getfield
						break;
					}
				}

				methodNode.instructions.remove(zan11.getNext());
				methodNode.instructions.remove(zan22.getNext());
				methodNode.instructions.remove(zan33.getNext());

				InsnList furkanadam = new InsnList();
				furkanadam
						.add(new MethodInsnNode(INVOKESTATIC, "joptsimple/internal/dev/sabo/module/mods/Reach", "getValue", "()D", false));
				methodNode.instructions.insert(zan1, furkanadam);

				InsnList furkanadam1 = new InsnList();
				furkanadam1
						.add(new MethodInsnNode(INVOKESTATIC, "joptsimple/internal/dev/sabo/module/mods/Reach", "getValue", "()D", false));

				methodNode.instructions.insert(zan2, furkanadam1);

				InsnList furkanadam2 = new InsnList();
				furkanadam2
						.add(new MethodInsnNode(INVOKESTATIC, "joptsimple/internal/dev/sabo/module/mods/Reach", "getValue", "()D", false));
				methodNode.instructions.insert(zan3, furkanadam2);

				InsnList furkanadam11 = new InsnList();
				furkanadam11
						.add(new MethodInsnNode(INVOKESTATIC, "joptsimple/internal/dev/sabo/module/mods/Reach", "getValue", "()D", false));
				methodNode.instructions.insert(zan11, furkanadam11);

				InsnList furkanadam22 = new InsnList();
				furkanadam22
						.add(new MethodInsnNode(INVOKESTATIC, "joptsimple/internal/dev/sabo/module/mods/Reach", "getValue", "()D", false));
				methodNode.instructions.insert(zan22, furkanadam22);

				InsnList furkanadam33 = new InsnList();
				furkanadam33
						.add(new MethodInsnNode(INVOKESTATIC, "joptsimple/internal/dev/sabo/module/mods/Reach", "getValue", "()D", false));
				methodNode.instructions.insert(zan33, furkanadam33);
			}
		}
	}

}
