package spicy.transformers;

import java.util.List;

import spicy.Injector;
import voidutilities.ClassReader;
import voidutilities.tree.ClassNode;
import voidutilities.tree.MethodNode;

public class TagsTransformer extends Injector {

	public int control = 0;
	public int control2 = 0;
	public int control22 = 0;

	@Override
	public void inject(ClassReader classReader, ClassNode classNode) {
		for (MethodNode methodNode : (List<MethodNode>) classNode.methods) {
//	    	if ((classNode.name.contains(ClassNames.getNameIndex(ClassNames.rendererlivingentity)) && methodNode.name.equals(ClassNames.passSpecialRender)) && methodNode.desc.equals("(" + ClassNames.getDesc(ClassNames.entitylivingbase) + "DDD)V")) {//RendererLivingEntity.class passSpecialRender methodu
//
//	    		AbstractInsnNode targetCode = null;
//
//	    		for (AbstractInsnNode abs : methodNode.instructions.toArray()) {
//	    			if (abs.getOpcode() == INVOKEVIRTUAL && abs.getNext().getOpcode() == IFEQ && ((MethodInsnNode)abs).name.equals(ClassNames.isSneaking)) {//isSneaking
//	    				++control;
//	    				if (control == 2) {
//	    					targetCode = abs.getPrevious();
//	    				}
//	    			}
//	    		}
//
//	    		methodNode.instructions.remove(targetCode.getNext());
//
//	    		InsnList insnList = new InsnList();
//
//	    		insnList.add(new MethodInsnNode(INVOKESTATIC, "xyz/spicy/module/mods/Tags", "getState2", "()Z", false));
//
//	    		methodNode.instructions.insert(targetCode, insnList);
//
//	    		AbstractInsnNode targetCode1 = null;
//
//	    		for (AbstractInsnNode abs : methodNode.instructions.toArray()) {
//	    			if (abs instanceof LdcInsnNode) {
//	    				if (((LdcInsnNode) abs).cst.toString().contains("553648127")) {
//	    					targetCode1 = abs.getPrevious();
//	    				}
//	    			}
//	    		}
//
//	    		methodNode.instructions.remove(targetCode1.getNext());
//
//	    		InsnList insnList5 = new InsnList();
//
//	    		insnList5.add(new LdcInsnNode(new Integer(-65536)));
//
//	    		methodNode.instructions.insert(targetCode1, insnList5);
//
//
//	    		AbstractInsnNode targetCode11 = null;
//	    		AbstractInsnNode targetCode2 = null;
//	    		AbstractInsnNode targetCode3 = null;
//	    		AbstractInsnNode targetCode4 = null;
//
//	    		for (AbstractInsnNode abs : methodNode.instructions.toArray()) {
//	    			if (abs instanceof LdcInsnNode) {
//	    				if (((LdcInsnNode) abs).cst.toString().contains("0.25")) {
//	    					if (control22 == 3) {
//	    						targetCode4 = abs.getPrevious();
//	    						++control22;
//	    					}
//	    					if (control22 == 2) {
//	    						targetCode3 = abs.getPrevious();
//	    						++control22;
//	    					}
//	    					if (control22 == 1) {
//	    						targetCode2 = abs.getPrevious();
//	    						++control22;
//	    					}
//	    					if (control22 == 0) {
//	    						targetCode11 = abs.getPrevious();
//	    						++control22;
//	    					}
//	    				}
//	    			}
//	    		}
//
//	    		methodNode.instructions.remove(targetCode11.getNext());
//	    		methodNode.instructions.remove(targetCode2.getNext());
//	    		methodNode.instructions.remove(targetCode3.getNext());
//	    		methodNode.instructions.remove(targetCode4.getNext());
//
//	    		InsnList insnList2 = new InsnList();
//
//	    		insnList2.add(new FieldInsnNode(INVOKESTATIC, "xyz/spicy/module/mods/Tags", "getRect", "()F"));
//
//	    		InsnList insnList3 = new InsnList();
//
//	    		insnList3.add(new FieldInsnNode(INVOKESTATIC, "xyz/spicy/module/mods/Tags", "getRect", "()F"));
//
//	    		InsnList insnList4 = new InsnList();
//
//	    		insnList4.add(new FieldInsnNode(INVOKESTATIC, "xyz/spicy/module/mods/Tags", "getRect", "()F"));
//
//	    		InsnList insnList6 = new InsnList();
//
//	    		insnList6.add(new FieldInsnNode(INVOKESTATIC, "xyz/spicy/module/mods/Tags", "getRect", "()F"));
//
//	    		methodNode.instructions.insert(targetCode11, insnList2);
//	    		methodNode.instructions.insert(targetCode2, insnList3);
//	    		methodNode.instructions.insert(targetCode3, insnList4);
//	    		methodNode.instructions.insert(targetCode4, insnList6);
//	    	}
//	    	if ((classNode.name.contains(ClassNames.getNameIndex(ClassNames.render)) && methodNode.name.equals(ClassNames.renderLivingLabel)) && methodNode.desc.equals("(" + ClassNames.getDesc(ClassNames.entity) + "Ljava/lang/String;DDDI)V")) {//Render class�ndaki renderLivingLabel
//
//	    		AbstractInsnNode targetCode1 = null;
//	    		AbstractInsnNode targetCode2 = null;
//	    		AbstractInsnNode targetCode3 = null;
//	    		AbstractInsnNode targetCode4 = null;
//
//	    		for (AbstractInsnNode abs : methodNode.instructions.toArray()) {
//	    			if (abs instanceof LdcInsnNode) {
//	    				if (((LdcInsnNode) abs).cst.toString().contains("0.25")) {
//	    					if (control2 == 3) {
//	    						targetCode4 = abs.getPrevious();
//	    						++control2;
//	    					}
//	    					if (control2 == 2) {
//	    						targetCode3 = abs.getPrevious();
//	    						++control2;
//	    					}
//	    					if (control2 == 1) {
//	    						targetCode2 = abs.getPrevious();
//	    						++control2;
//	    					}
//	    					if (control2 == 0) {
//	    						targetCode1 = abs.getPrevious();
//	    						++control2;
//	    					}
//	    				}
//	    			}
//	    		}
//
//	    		methodNode.instructions.remove(targetCode1.getNext());
//	    		methodNode.instructions.remove(targetCode2.getNext());
//	    		methodNode.instructions.remove(targetCode3.getNext());
//	    		methodNode.instructions.remove(targetCode4.getNext());
//
//	    		InsnList insnList2 = new InsnList();
//
//	    		insnList2.add(new FieldInsnNode(INVOKESTATIC, "xyz/spicy/module/mods/Tags", "getRect", "()F"));
//
//	    		InsnList insnList3 = new InsnList();
//
//	    		insnList3.add(new FieldInsnNode(INVOKESTATIC, "xyz/spicy/module/mods/Tags", "getRect", "()F"));
//
//	    		InsnList insnList4 = new InsnList();
//
//	    		insnList4.add(new FieldInsnNode(INVOKESTATIC, "xyz/spicy/module/mods/Tags", "getRect", "()F"));
//
//	    		InsnList insnList5 = new InsnList();
//
//	    		insnList5.add(new FieldInsnNode(INVOKESTATIC, "xyz/spicy/module/mods/Tags", "getRect", "()F"));
//
//	    		methodNode.instructions.insert(targetCode1, insnList2);
//	    		methodNode.instructions.insert(targetCode2, insnList3);
//	    		methodNode.instructions.insert(targetCode3, insnList4);
//	    		methodNode.instructions.insert(targetCode4, insnList5);
//
//
//	    		for (AbstractInsnNode abs : methodNode.instructions.toArray()) {
//	    			if (abs instanceof LdcInsnNode) {
//	    				if (((LdcInsnNode) abs).cst.toString().contains("553648127")) {
//	    					targetCode1 = abs.getPrevious();
//	    				}
//	    			}
//	    		}
//
//	    		methodNode.instructions.remove(targetCode1.getNext());
//
//	    		InsnList insnList6 = new InsnList();
//
//	    		insnList6.add(new LdcInsnNode(new Integer(-65536)));
//
//	    		methodNode.instructions.insert(targetCode1, insnList6);
//	    	}
		}
	}
}
