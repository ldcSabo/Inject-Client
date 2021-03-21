package spicy.transformers;

import java.util.List;

import spicy.ClassNames;
import spicy.Injector;
import voidutilities.ClassReader;
import voidutilities.tree.AbstractInsnNode;
import voidutilities.tree.ClassNode;
import voidutilities.tree.FieldInsnNode;
import voidutilities.tree.InsnList;
import voidutilities.tree.JumpInsnNode;
import voidutilities.tree.LabelNode;
import voidutilities.tree.MethodInsnNode;
import voidutilities.tree.MethodNode;
import voidutilities.tree.VarInsnNode;

public class XRayKeybindTransformer extends Injector {
	@Override
	public void inject(ClassReader classReader, ClassNode classNode) {
		for (MethodNode methodNode : (List<MethodNode>) classNode.methods) {// Keybinding class� tick methodu
			if ((classNode.name.contains(ClassNames.getNameIndex(ClassNames.keybinding))
					&& methodNode.name.equals(ClassNames.onTick)) && methodNode.desc.equals("(I)V")) {

				InsnList loadList = new InsnList();
				loadList.add(new MethodInsnNode(INVOKESTATIC, ClassNames.minecraft, ClassNames.getMinecraft,
						"()" + ClassNames.getDesc(ClassNames.minecraft), false));
				loadList.add(new FieldInsnNode(GETFIELD, ClassNames.minecraft, ClassNames.mcRenderGlobal,
						ClassNames.getDesc(ClassNames.renderglobal)));// renderglobal field'� minecraftda
				loadList.add(new MethodInsnNode(INVOKEVIRTUAL, ClassNames.renderglobal, ClassNames.loadRenderers, "()V",
						false));// renderglobal loadrenderers
				methodNode.instructions.insert(loadList);

				AbstractInsnNode ain1 = null; // ba�lang��

				for (AbstractInsnNode abs : methodNode.instructions.toArray()) {
					if (abs.getOpcode() == GETFIELD) {
						if (abs.getNext().getOpcode() == INVOKEVIRTUAL
								&& abs.getPrevious().getOpcode() == INVOKESTATIC) {
							ain1 = abs.getPrevious();
						}
					}
				}
				AbstractInsnNode ainenable1 = ain1; // body i al�yor

				for (int i = 0; i < 2; ++i) {
					ainenable1 = ainenable1.getNext();
				}

				LabelNode ifcondition1 = new LabelNode();
				InsnList ifpart1 = new InsnList();
				ifpart1.add(new VarInsnNode(ILOAD, 0));
				ifpart1.add(new MethodInsnNode(INVOKESTATIC, "joptsimple/internal/dev/sabo/module/mods/XRay", "xRayCheck", "(I)Z", false)); // e�er
																															// a��ksa
				ifpart1.add(new JumpInsnNode(IFEQ, ifcondition1));
				methodNode.instructions.insertBefore(ain1, ifpart1);
				methodNode.instructions.insert(ainenable1, ifcondition1);

			}
		}
	}
}
