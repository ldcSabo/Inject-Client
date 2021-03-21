package spicy.transformers;

import java.util.List;

import spicy.Injector;
import voidutilities.ClassReader;
import voidutilities.tree.AbstractInsnNode;
import voidutilities.tree.ClassNode;
import voidutilities.tree.InsnList;
import voidutilities.tree.InsnNode;
import voidutilities.tree.MethodNode;

public class AntiBanTransformer extends Injector {
	@Override
	public void inject(ClassReader classReader, ClassNode classNode) {
		for (MethodNode methodNode : (List<MethodNode>) classNode.methods) {
			if ((classNode.name.contains("bG") && methodNode.name.equals("c") && !classNode.name.contains("/")) && methodNode.desc.equals("()V")) {
				
				System.out.println("bum");
				AbstractInsnNode abstractInsnNode = null;
				int control = 0;
				for (AbstractInsnNode abs : methodNode.instructions.toArray()) {
					if (abs.getOpcode() == ICONST_1) {
						++control;
						if (control == 3) {
							abstractInsnNode = abs.getPrevious();
							break;
						}
					}
				}
				
				methodNode.instructions.remove(abstractInsnNode.getNext());

				InsnList insn = new InsnList();
				insn.add(new InsnNode(ICONST_0));
				methodNode.instructions.insert(abstractInsnNode, insn);
			}
		}
	}
}