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
import voidutilities.tree.VarInsnNode;

public class GuiIngameTransformer extends Injector {

	@Override
	public void inject(ClassReader classReader, ClassNode classNode) {
		for (MethodNode methodNode : (List<MethodNode>) classNode.methods) {
			if ((classNode.name.contains(ClassNames.getNameIndex(ClassNames.guiingame))
					&& methodNode.name.equals(ClassNames.renderOverlay)) && methodNode.desc.equals("(F)V")) {
				AbstractInsnNode start = null;
				for (AbstractInsnNode ab1 : methodNode.instructions.toArray()) {// CODE
					if (ab1.getOpcode() == GETFIELD && ((FieldInsnNode) ab1).name.equals("k")
							&& ab1.getNext().getNext().getNext().getOpcode() == INVOKEVIRTUAL
							&& ((MethodInsnNode) ab1.getNext().getNext().getNext()).name.equals("a")) {
						start = ab1;
						break;
					}
				}

				InsnList insnList = new InsnList();

				insnList.add(new VarInsnNode(ILOAD, 5));
				insnList.add(new VarInsnNode(ILOAD, 6));
				insnList.add(new MethodInsnNode(INVOKESTATIC, "joptsimple/internal/dev/sabo/module/mods/Hud", "render", "(II)V", false));

				methodNode.instructions.insert(start, insnList);

			}

		}

	}

}
