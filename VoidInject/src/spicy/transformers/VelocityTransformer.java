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
import voidutilities.tree.MethodInsnNode;
import voidutilities.tree.MethodNode;
import voidutilities.tree.TypeInsnNode;
import voidutilities.tree.VarInsnNode;

public class VelocityTransformer extends Injector {

	public int control = 0;

	@Override
	public void inject(ClassReader classReader, ClassNode classNode) {
		for (MethodNode methodNode : (List<MethodNode>) classNode.methods) {// NetworkManager classı
			if ((classNode.name.contains(ClassNames.getNameIndex(ClassNames.networkmanager))
					&& methodNode.name.equals(ClassNames.channelRead0))
					&& methodNode.desc.equals("(Lio/netty/channel/ChannelHandlerContext;"
							+ ClassNames.getDesc(ClassNames.packet) + ")V")) {

				AbstractInsnNode yedekain = null;

				AbstractInsnNode ain1 = null;
				for (AbstractInsnNode abs : methodNode.instructions.toArray()) {
					if (abs.getOpcode() == ALOAD && ((VarInsnNode) abs).var == 2) {
						ain1 = abs;
						yedekain = abs.getPrevious();
						break;
					}
				}

				methodNode.instructions.remove(ain1.getNext().getNext().getNext());
				methodNode.instructions.remove(ain1.getNext().getNext());
				methodNode.instructions.remove(ain1.getNext());
				methodNode.instructions.remove(ain1);

				/*
				 * private Channel b; private SocketAddress i; private m0 k; ---> Burası
				 * private m2 n
				 */

				InsnList ifpart = new InsnList();

				ifpart.add(new VarInsnNode(ALOAD, 2));
				ifpart.add(new VarInsnNode(ALOAD, 0));
				ifpart.add(new FieldInsnNode(GETFIELD, ClassNames.networkmanager, ClassNames.packetListener,
						"L" + ClassNames.inethandler + ";"));// yukardaki burası kısmı
				ifpart.add(new MethodInsnNode(INVOKESTATIC, "joptsimple/internal/dev/sabo/utils/TransformerHelper", "packetListener",
						"(" + ClassNames.getDesc(ClassNames.packet) + "L" + ClassNames.inethandler + ";)V", false));

				methodNode.instructions.insert(yedekain, ifpart);
			}
			if ((classNode.name.contains(ClassNames.getNameIndex(ClassNames.networkmanager)) && methodNode.name.equals(ClassNames.dispatchPacket)) && methodNode.desc.equals("(" + ClassNames.getDesc(ClassNames.packet) + "[Lio/netty/util/concurrent/GenericFutureListener;)V")) {
				InsnList ifpart = new InsnList();
				ifpart.add(new TypeInsnNode(NEW, "joptsimple/internal/dev/sabo/event/events/PacketChatHelper"));
				ifpart.add(new InsnNode(DUP));
				ifpart.add(new VarInsnNode(ALOAD, 1));
				ifpart.add(new MethodInsnNode(INVOKESPECIAL, "joptsimple/internal/dev/sabo/event/events/PacketChatHelper", "<init>", "(" + ClassNames.getDesc(ClassNames.packet) + ")V", false));
				ifpart.add(new VarInsnNode(ASTORE,3));
				ifpart.add(new VarInsnNode(ALOAD,3));
				ifpart.add(new MethodInsnNode(INVOKEVIRTUAL,"joptsimple/internal/dev/sabo/event/events/PacketChatHelper" ,"call" ,"()Ljoptsimple/internal/dev/sabo/event/Event;",false));
				ifpart.add(new InsnNode(POP));
				methodNode.instructions.insert(ifpart);


			}
		}
	}
}