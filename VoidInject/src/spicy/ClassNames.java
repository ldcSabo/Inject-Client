package spicy;

public class ClassNames {

	public static String minecraft = "net/minecraft/client/it";// ------------------------------ 1
	// FIELDS
	public static String mcRenderGlobal = "q";
	public static String thePlayer = "a4";
	public static String rightclickdelay = "z";
	public static String theWorld = "aW";
	public static String mcGameSettings = "ag";
	public static String mcPlayerController = "aU";
	public static String movingObjectPos = "P";

	// METHODS
	public static String getHandleClient = "a";
	public static String getMinecraft = "a";
	public static String run = "f";
	public static String runTick = "A";

	public static String entityplayersp = "net/minecraft/client/gI";// ------------------------------ 1

	// FIELDS
	public static String SPmovementInput = "cJ";

	// METHODS

	public static String onUpdateWalkingPlayer = "X";
	public static String onLivingUpdate = "G";

	public static String entityplayer = "net/minecraft/ov";// ------------------------------

	// FIELDS
	public static String inventory = "bR";

	// METHODS
	public static String getHeldItem = "a";
	public static String isUsingItem = "f";

	public static String entitylivingbase = "net/minecraft/bm";// ------------------------------

	// METHODS
	public static String isPotionActive = "b"; // int li ise b değilse a
	public static String getActivePotionEffect = "a";
	// public static String passSpecialRender = "b"; //((renderName))

	public static String entity = "net/minecraft/nE";// ------------------------------

	// FIELDS
	public static String prevposX = "af";
	public static String prevposY = "ae";
	public static String prevposZ = "at";
	public static String posX = "o";
	public static String posY = "N";
	public static String posZ = "ac";
	public static String motionX = "aw";
	public static String motionY = "aa";
	public static String motionZ = "f";
	public static String rotationYaw = "t";
	public static String rotationPitch = "A";
	public static String prevRotationYaw = "a";
	public static String prevRotationPitch = "ao";
	public static String onground = "C";
	public static String ticksexisted = "V";

	// METHODS
	public static String moveEntity = "e";
	public static String eyeHeight = "l";
	public static String getDistanceToEntity = "a";
	public static String getName = "b";
	public static String isSneaking = "S";

	public static String entityrenderer = "net/minecraft/client/jc";// ------------------------------

	// METHODS
	public static String getMouseOver = "c";

	public static String iblockstate = "net/minecraft/gf";// ------------------------------

	// METHODS
	public static String getBlock = "a";

	public static String keybinding = "net/minecraft/client/at";// ------------------------------

	// METHODS
	public static String onTick = "b";

	public static String block = "net/minecraft/a";// ------------------------------

	// METHODS
	public static String getBlockByID = "a";
	public static String shouldSideBeRendered = "a";

	public static String world = "net/minecraft/ww";// ------------------------------

	// FIELDS
	public static String playerEntities = "K";

	// METHODS
	public static String getBlockState = "a";
	public static String updateEntityWithOptionalForce = "a";

	public static String playercontrollermp = "net/minecraft/client/eK";// ------------------------------

	// FIELDS
	public static String curBlockDamageMP = "e";
	public static String blockHitDelay = "d";

	// METHODS
	public static String func_180512_c = "b"; // --->> SpeedMine kodu burda a��a��s�ndaki methodda
												// getblockreachdistance var
	public static String func_178890_a = "a"; // --->> syncCurrentPlayItem �n alt�ndaki method

	public static String item = "net/minecraft/mT";// ------------------------------

	public static String itemstack = "net/minecraft/f4";// ------------------------------

	// METHODS
	public static String getItem = "a";

	public static String potion = "net/minecraft/le";// ------------------------------

	// METHODS
	public static String id = "E";

	public static String potioneffect = "net/minecraft/wo";// ------------------------------

	public static String guiingame = "net/minecraft/client/gW";// ------------------------------

	// FIELDS
	// Hud helper field = "k"; //Sabo burayı yapacak

	// METHODS
	public static String renderOverlay = "a";

	public static String gamesettings = "net/minecraft/client/Z";// ------------------------------

	// FIELDS
	public static String ambientOcclusion = "bj";
	public static String gammaSettings = "ao";

	public static String networkmanager = "net/minecraft/eP";// ------------------------------

	// FIELDS
	public static String packetListener = "g";

	// METHODS
	public static String channelRead0 = "a";
	public static String dispatchPacket = "a";

	public static String c02packetentityuse = "net/minecraft/wK";// ------------------------------

	public static String ACTION = "net/minecraft/gJ";// ------------------------------

	public static String c03packetplayer = "net/minecraft/lX";// ------------------------------

	public static String c01packetchatmessage = "net/minecraft/xy";// ------------------------------

	public static String s12packetentityvelocity = "net/minecraft/mV";// ------------------------------

	public static String banpacket = "net/minecraft/ax";// ------------------------------

	public static String inventoryplayer = "net/minecraft/et"; // ------------------------------

	// FIELDS
	public static String currentItem = "b";

	// METHODS
	public static String getStackInSlot = "a";
	public static String getCurrentItem = "b";

	public static String enumfacing = "net/minecraft/m1";// ------------------------------

	public static String itemblock = "net/minecraft/mG";// ------------------------------

	public static String movementinput = "net/minecraft/ez";// ------------------------------

	public static String moveStrafe = "b";
	public static String moveForward = "a";
	public static String jump = "d";
	public static String sneak = "c";

	public static String renderglobal = "net/minecraft/client/fF";// ------------------------------

	// METHODS
	public static String loadRenderers = "c";

	public static String packet = "net/minecraft/kR";// ------------------------------

	public static String nethandlerplayclient = "net/minecraft/client/b";// ------------------------------

	// METHODS
	public static String addToSendQueue = "a";

	public static String worldclient = "net/minecraft/client/jP";// ------------------------------

	public static String blocks = "net/minecraft/er";// ------------------------------

	// FIELDS
	public static String air = "bv";
	public static String flowing_water = "cg";
	public static String water = "as";
	public static String flowing_lava = "bL";
	public static String lava = "az";
	public static String fire = "a2";
	public static String web = "C";
	public static String tnt = "am";

	public static String vec3 = "net/minecraft/wU";// ------------------------------

	public static String vec3i = "net/minecraft/vW";// ------------------------------

	public static String inethandler = "net/minecraft/wM";// ------------------------------

	public static String iblockaccess = "net/minecraft/hS";// ----------------------------

	public static String add = "a";// BLOCKPOS Class

	public static String getDesc(String name) {
		return "L" + name + ";";
	}

	public static String getNameIndex(String className) {
		int lastindex = 0;
		for (char c : className.toCharArray()) {
			if (c == '/') {
				++lastindex;
			}
		}
		return className.split("/")[lastindex];
	}

	public static String agentHelper(String className) {
		return className.replace("/", ".");
	}
}