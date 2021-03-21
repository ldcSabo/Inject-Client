package spicy;

import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;
import java.util.Arrays;

import spicy.transformers.AntiBanTransformer;
import spicy.transformers.ClientTransformer;
import spicy.transformers.ConnectTransformer;
import spicy.transformers.EntityTransformer;
import spicy.transformers.GammaTransformer;
import spicy.transformers.GuiIngameTransformer;
import spicy.transformers.PlayerControllerTransformer;
import spicy.transformers.ReachTransformer;
import spicy.transformers.ScaffoldTransformer;
import spicy.transformers.VelocityTransformer;
import spicy.transformers.WorldTransformer;
import spicy.transformers.XRayKeybindTransformer;
import spicy.transformers.XRayTransformer;

public class Agent {
	public static void agentmain(final String args, final Instrumentation instrumentation) {
		System.out.println("Olmus la za");

		 instrumentation.addTransformer(new ClientTransformer(), true);
		 instrumentation.addTransformer(new PlayerControllerTransformer(), true);
		 instrumentation.addTransformer(new XRayTransformer(), true);
		 instrumentation.addTransformer(new XRayKeybindTransformer(), true);
		 instrumentation.addTransformer(new GammaTransformer(), true);
		 instrumentation.addTransformer(new VelocityTransformer(), true);
		 instrumentation.addTransformer(new ScaffoldTransformer(), true);
		 instrumentation.addTransformer(new EntityTransformer(), true);
		 instrumentation.addTransformer(new ReachTransformer(), true);
		 instrumentation.addTransformer(new WorldTransformer(), true);
		 instrumentation.addTransformer(new GuiIngameTransformer(), true);
		 instrumentation.addTransformer(new ConnectTransformer(), true);
		 instrumentation.addTransformer(new AntiBanTransformer(), true);
		Arrays.stream(instrumentation.getAllLoadedClasses()).forEach(aClass -> {
			if (aClass.getName().contains("joptsimple.internal.dev.sabo.utils.TransformerHelper")
					&& aClass.getName().contains("joptsimple.internal.dev.sabo.module.mods.Scaffold")
					&& aClass.getName().contains(ClassNames.agentHelper(ClassNames.minecraft))
					&& aClass.getName().contains(ClassNames.agentHelper(ClassNames.potion))
					&& aClass.getName().contains(ClassNames.agentHelper(ClassNames.entityplayer))
					&& aClass.getName().contains(ClassNames.agentHelper(ClassNames.keybinding))
					&& aClass.getName().contains(ClassNames.agentHelper(ClassNames.playercontrollermp))
					&& aClass.getName().contains(ClassNames.agentHelper(ClassNames.gamesettings))
					&& aClass.getName().contains(ClassNames.agentHelper(ClassNames.guiingame))
					&& aClass.getName().contains(ClassNames.agentHelper(ClassNames.networkmanager))
					&& aClass.getName().contains(ClassNames.agentHelper(ClassNames.entityrenderer))
					&& aClass.getName().contains(ClassNames.agentHelper(ClassNames.entityplayersp))
					&& aClass.getName().contains(ClassNames.agentHelper(ClassNames.world))
					&& (aClass.getName().contains("bG") && !aClass.getName().contains("."))
					&& aClass.getName().contains(ClassNames.agentHelper(ClassNames.block))
					&& aClass.getName().contains(ClassNames.agentHelper(ClassNames.entity))) {
				try {
					
					instrumentation.retransformClasses(aClass);
				} catch (UnmodifiableClassException ex) {
				}
			}
		});
	}
}
