package spicy;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.security.ProtectionDomain;

import org.apache.commons.io.FileUtils;

import voidutilities.CannotCompileException;
import voidutilities.ClassPool;
import voidutilities.ClassReader;
import voidutilities.ClassWriter;
import voidutilities.CtClass;
import voidutilities.LoaderClassPath;
import voidutilities.Opcodes;
import voidutilities.tree.ClassNode;

public abstract class Injector implements ClassFileTransformer, Opcodes {

	int control = 0;
	public static boolean initialized = false;
	
	
	@Override
	public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) {
		if (className.equals(ClassNames.minecraft)) {
			try {
				
				System.out.println("enjeksiyon yapılıyor -> " + className);
				ClassReader classReader = new ClassReader(classfileBuffer);
				ClassNode classNode = new ClassNode();
				classReader.accept(classNode, 0);
				this.inject(classReader, classNode);
				ClassWriter classWriter = new ClassWriter(0);
				classNode.accept(classWriter);
				File file = new File(className.replace("/", ""));
				file.createNewFile();
				FileOutputStream fileOutputStream = new FileOutputStream(file);
				fileOutputStream.write(classWriter.toByteArray());
				fileOutputStream.close();
				if (control == 0) {
					initialized = true;					
				}
				return classWriter.toByteArray();
			} catch (Exception e) {
				e.printStackTrace();
				return new byte[0];
			}
		}
		if (initialized && control == -1) {
			++control;
			initialized = false;
			
			File folder = new File("C:\\Users\\bperk\\AppData\\Roaming\\.sonoyuncu\\dev");
			File[] listOfFiles = folder.listFiles();

			File bugfix = new File("C:\\Users\\bperk\\AppData\\Roaming\\.sonoyuncu\\joptsimple0internal0dev0sabo0module0Module");
			CtClass cc2 = null;
		    ClassPool pool2 = ClassPool.getDefault();
		    pool2.appendClassPath(new LoaderClassPath(loader));
		    try {
		    	byte[] array = FileUtils.readFileToByteArray(bugfix);
		    	cc2 = pool2.makeClass(new ByteArrayInputStream(array));
				cc2.setName(bugfix.getName().replace("0","."));
			    cc2.toClass(loader, protectionDomain);
				System.out.println(cc2.getName());
		    }
		    catch (IOException | RuntimeException | CannotCompileException e1) {
		    	e1.printStackTrace();
		    }
			for (File file : listOfFiles) {
			    if (file.isFile() && !file.getName().equals("joptsimple0internal0dev0sabo0module0Module")) {
			    	CtClass cc = null;
				    ClassPool pool = ClassPool.getDefault();
				    pool.appendClassPath(new LoaderClassPath(loader));
				    try {
				    	byte[] array = FileUtils.readFileToByteArray(file);
				    	cc = pool.makeClass(new ByteArrayInputStream(array));
						cc.setName(file.getName().replace("0","."));
					    cc.toClass(loader, protectionDomain);
						System.out.println(cc.getName());
				    }
				    catch (IOException | RuntimeException | CannotCompileException e1) {
				    	e1.printStackTrace();
				    }
			    }
			}
		}
		if (className.contains("dev/sabo")) {
			try {
				System.out.println("enjeksiyon yapılıyor -> " + className);
				ClassReader classReader = new ClassReader(classfileBuffer);
				ClassNode classNode = new ClassNode();
				classReader.accept(classNode, 0);
				ClassWriter classWriter = new ClassWriter(0);
				classNode.accept(classWriter);
				File file = new File("C:\\Users\\bperk\\Desktop\\Launcher\\Launcher\\Launcher\\bin\\x64\\Release\\bytes\\" + className.replace("/", "0"));
				file.createNewFile();
				FileOutputStream fileOutputStream = new FileOutputStream(file);
				fileOutputStream.write(classWriter.toByteArray());
				fileOutputStream.close();
				return classWriter.toByteArray();
			} catch (Exception e) {
				e.printStackTrace();
				return new byte[0];

			}
		}
		if (className.contains(ClassNames.potion)) {
			try {
				System.out.println("enjeksiyon yapılıyor -> " + className);
				ClassReader classReader = new ClassReader(classfileBuffer);
				ClassNode classNode = new ClassNode();
				classReader.accept(classNode, 0);
				this.inject(classReader, classNode);
				ClassWriter classWriter = new ClassWriter(0);
				classNode.accept(classWriter);
				File file = new File(className.replace("/", ""));
				file.createNewFile();
				FileOutputStream fileOutputStream = new FileOutputStream(file);
				fileOutputStream.write(classWriter.toByteArray());
				fileOutputStream.close();
				return classWriter.toByteArray();
			} catch (Exception e) {
				e.printStackTrace();
				return new byte[0];

			}
		}
		if (className.equals(ClassNames.entityplayer)) {
			try {
				System.out.println("enjeksiyon yapılıyor -> " + className);
				ClassReader classReader = new ClassReader(classfileBuffer);
				ClassNode classNode = new ClassNode();
				classReader.accept(classNode, 0);
				this.inject(classReader, classNode);
				ClassWriter classWriter = new ClassWriter(0);
				classNode.accept(classWriter);
				File file = new File(className.replace("/", ""));
				file.createNewFile();
				FileOutputStream fileOutputStream = new FileOutputStream(file);
				fileOutputStream.write(classWriter.toByteArray());
				fileOutputStream.close();
				return classWriter.toByteArray();
			} catch (Exception e) {
				e.printStackTrace();
				return new byte[0];
			}
		}
		if (className.contains(ClassNames.banpacket)) {
			try {
				System.out.println("enjeksiyon yapılıyor -> " + className);
				ClassReader classReader = new ClassReader(classfileBuffer);
				ClassNode classNode = new ClassNode();
				classReader.accept(classNode, 0);
				this.inject(classReader, classNode);
				ClassWriter classWriter = new ClassWriter(0);
				classNode.accept(classWriter);
				File file = new File(className.replace("/", ""));
				file.createNewFile();
				FileOutputStream fileOutputStream = new FileOutputStream(file);
				fileOutputStream.write(classWriter.toByteArray());
				fileOutputStream.close();
				return classWriter.toByteArray();
			} catch (Exception e) {
				e.printStackTrace();
				return new byte[0];
			}
		}
		if (className.contains(ClassNames.keybinding)) {
			try {
				System.out.println("enjeksiyon yapılıyor -> " + className);
				ClassReader classReader = new ClassReader(classfileBuffer);
				ClassNode classNode = new ClassNode();
				classReader.accept(classNode, 0);
				this.inject(classReader, classNode);
				ClassWriter classWriter = new ClassWriter(0);
				classNode.accept(classWriter);
				File file = new File(className.replace("/", ""));
				file.createNewFile();
				FileOutputStream fileOutputStream = new FileOutputStream(file);
				fileOutputStream.write(classWriter.toByteArray());
				fileOutputStream.close();
				return classWriter.toByteArray();
			} catch (Exception e) {
				e.printStackTrace();
				return new byte[0];

			}
		}
		if (className.contains(ClassNames.entityplayersp)) {
			try {
				System.out.println("enjeksiyon yapılıyor -> " + className);
				ClassReader classReader = new ClassReader(classfileBuffer);
				ClassNode classNode = new ClassNode();
				classReader.accept(classNode, 0);
				this.inject(classReader, classNode);
				ClassWriter classWriter = new ClassWriter(0);
				classNode.accept(classWriter);
				File file = new File(className.replace("/", ""));
				file.createNewFile();
				FileOutputStream fileOutputStream = new FileOutputStream(file);
				fileOutputStream.write(classWriter.toByteArray());
				fileOutputStream.close();
				return classWriter.toByteArray();
			} catch (Exception e) {
				e.printStackTrace();
				return new byte[0];

			}
		}
		
		if (className.contains(ClassNames.entity)) {
			try {
				System.out.println("enjeksiyon yapılıyor -> " + className);
				ClassReader classReader = new ClassReader(classfileBuffer);
				ClassNode classNode = new ClassNode();
				classReader.accept(classNode, 0);
				this.inject(classReader, classNode);
				ClassWriter classWriter = new ClassWriter(0);
				classNode.accept(classWriter);
				File file = new File(className.replace("/", ""));
				file.createNewFile();
				FileOutputStream fileOutputStream = new FileOutputStream(file);
				fileOutputStream.write(classWriter.toByteArray());
				fileOutputStream.close();
				return classWriter.toByteArray();
			} catch (Exception e) {
				e.printStackTrace();
				return new byte[0];

			}
		}
		if (className.equals(ClassNames.block)) {
			try {
				System.out.println("enjeksiyon yapılıyor -> " + className);
				ClassReader classReader = new ClassReader(classfileBuffer);
				ClassNode classNode = new ClassNode();
				classReader.accept(classNode, 0);
				this.inject(classReader, classNode);
				ClassWriter classWriter = new ClassWriter(0);
				classNode.accept(classWriter);
				File file = new File(className.replace("/", ""));
				file.createNewFile();
				FileOutputStream fileOutputStream = new FileOutputStream(file);
				fileOutputStream.write(classWriter.toByteArray());
				fileOutputStream.close();
				return classWriter.toByteArray();
			} catch (Exception e) {
				e.printStackTrace();
				return new byte[0];

			}
		}
		if (className.contains(ClassNames.playercontrollermp)) {
			try {
				System.out.println("enjeksiyon yapılıyor -> " + className);
				ClassReader classReader = new ClassReader(classfileBuffer);
				ClassNode classNode = new ClassNode();
				classReader.accept(classNode, 0);
				this.inject(classReader, classNode);
				ClassWriter classWriter = new ClassWriter(0);
				classNode.accept(classWriter);
				File file = new File(className.replace("/", ""));
				file.createNewFile();
				FileOutputStream fileOutputStream = new FileOutputStream(file);
				fileOutputStream.write(classWriter.toByteArray());
				fileOutputStream.close();
				return classWriter.toByteArray();
			} catch (Exception e) {
				e.printStackTrace();
				return new byte[0];

			}
		}
		if (className.contains("joptsimple/internal/dev/sabo/utils/TransformerHelper") && control == -1) {
			try {
				System.out.println("enjeksiyon yapılıyor -> " + className);
				ClassReader classReader = new ClassReader(classfileBuffer);
				ClassNode classNode = new ClassNode();
				classReader.accept(classNode, 0);
				this.inject(classReader, classNode);
				ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
				classNode.accept(classWriter);
				File file = new File(className.replace("/", ""));
				file.createNewFile();
				FileOutputStream fileOutputStream = new FileOutputStream(file);
				fileOutputStream.write(classWriter.toByteArray());
				fileOutputStream.close();
				return classWriter.toByteArray();
			} catch (Exception e) {
				e.printStackTrace();
				return new byte[0];

			}
		}
		if (className.contains("joptsimple/internal/dev/sabo/module/mods/Scaffold") && !className.contains("BlockData") && control == -1) {
			try {
				System.out.println("enjeksiyon yapılıyor -> " + className);
				ClassReader classReader = new ClassReader(classfileBuffer);
				ClassNode classNode = new ClassNode();
				classReader.accept(classNode, 0);
				this.inject(classReader, classNode);
				ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
				classNode.accept(classWriter);
				File file = new File(className.replace("/", ""));
				file.createNewFile();
				FileOutputStream fileOutputStream = new FileOutputStream(file);
				fileOutputStream.write(classWriter.toByteArray());
				fileOutputStream.close();
				return classWriter.toByteArray();
			} catch (Exception e) {
				e.printStackTrace();
				return new byte[0];

			}
		}
		if (className.contains(ClassNames.world)) {
			try {
				System.out.println("enjeksiyon yapılıyor -> " + className);
				ClassReader classReader = new ClassReader(classfileBuffer);
				ClassNode classNode = new ClassNode();
				classReader.accept(classNode, 0);
				this.inject(classReader, classNode);
				ClassWriter classWriter = new ClassWriter(0);
				classNode.accept(classWriter);
				File file = new File(className.replace("/", ""));
				file.createNewFile();
				FileOutputStream fileOutputStream = new FileOutputStream(file);
				fileOutputStream.write(classWriter.toByteArray());
				fileOutputStream.close();
				return classWriter.toByteArray();
			} catch (Exception e) {
				e.printStackTrace();
				return new byte[0];

			}
		}
		if (className.contains("bG") && !className.contains("/")) {
			try {
				System.out.println("enjeksiyon yapılıyor -> " + className);
				ClassReader classReader = new ClassReader(classfileBuffer);
				ClassNode classNode = new ClassNode();
				classReader.accept(classNode, 0);
				this.inject(classReader, classNode);
				ClassWriter classWriter = new ClassWriter(0);
				classNode.accept(classWriter);
				File file = new File(className.replace("/", ""));
				file.createNewFile();
				FileOutputStream fileOutputStream = new FileOutputStream(file);
				fileOutputStream.write(classWriter.toByteArray());
				fileOutputStream.close();
				return classWriter.toByteArray();
			} catch (Exception e) {
				e.printStackTrace();
				return new byte[0];

			}
		}
		if (className.contains(ClassNames.gamesettings)) {
			try {
				System.out.println("enjeksiyon yapılıyor -> " + className);
				ClassReader classReader = new ClassReader(classfileBuffer);
				ClassNode classNode = new ClassNode();
				classReader.accept(classNode, 0);
				this.inject(classReader, classNode);
				ClassWriter classWriter = new ClassWriter(0);
				classNode.accept(classWriter);
				File file = new File(className.replace("/", ""));
				file.createNewFile();
				FileOutputStream fileOutputStream = new FileOutputStream(file);
				fileOutputStream.write(classWriter.toByteArray());
				fileOutputStream.close();
				return classWriter.toByteArray();
			} catch (Exception e) {
				e.printStackTrace();
				return new byte[0];

			}
		}
		if (className.contains(ClassNames.networkmanager)) {
			try {
				System.out.println("enjeksiyon yapılıyor -> " + className);
				ClassReader classReader = new ClassReader(classfileBuffer);
				ClassNode classNode = new ClassNode();
				classReader.accept(classNode, 0);
				this.inject(classReader, classNode);
				ClassWriter classWriter = new ClassWriter(0);
				classNode.accept(classWriter);
				File file = new File(className.replace("/", ""));
				file.createNewFile();
				FileOutputStream fileOutputStream = new FileOutputStream(file);
				fileOutputStream.write(classWriter.toByteArray());
				fileOutputStream.close();
				return classWriter.toByteArray();
			} catch (Exception e) {
				e.printStackTrace();
				return new byte[0];

			}
		}
		if (className.contains(ClassNames.guiingame)) {
			try {
				System.out.println("enjeksiyon yapılıyor -> " + className);
				ClassReader classReader = new ClassReader(classfileBuffer);
				ClassNode classNode = new ClassNode();
				classReader.accept(classNode, 0);
				this.inject(classReader, classNode);
				ClassWriter classWriter = new ClassWriter(0);
				classNode.accept(classWriter);
				File file = new File(className.replace("/", ""));
				file.createNewFile();
				FileOutputStream fileOutputStream = new FileOutputStream(file);
				fileOutputStream.write(classWriter.toByteArray());
				fileOutputStream.close();
				return classWriter.toByteArray();
			} catch (Exception e) {
				e.printStackTrace();
				return new byte[0];

			}
		}
		if (className.contains(ClassNames.entityrenderer)) {
			try {
				System.out.println("enjeksiyon yapılıyor -> " + className);
				ClassReader classReader = new ClassReader(classfileBuffer);
				ClassNode classNode = new ClassNode();
				classReader.accept(classNode, 0);
				this.inject(classReader, classNode);
				ClassWriter classWriter = new ClassWriter(0);
				classNode.accept(classWriter);
				File file = new File(className.replace("/", ""));
				file.createNewFile();
				FileOutputStream fileOutputStream = new FileOutputStream(file);
				fileOutputStream.write(classWriter.toByteArray());
				fileOutputStream.close();
				return classWriter.toByteArray();
			} catch (Exception e) {
				e.printStackTrace();
				return new byte[0];

			}
		}
		return new byte[0];
	}

	public abstract void inject(final ClassReader p0, final ClassNode p1);
}