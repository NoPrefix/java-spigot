package net.noprefix.bedwars.Manager.GameManager;

import net.noprefix.bedwars.Main.Main;
import net.noprefix.bedwars.States.SizeState;

public class SizeManager {
	
	public static Integer getMaxPlayers() {
		if(Main.ss == SizeState.SIZE8x1) {
			return 8;
		}
		
		if(Main.ss == SizeState.SIZE4x2) {
			return 8;
		}
		if(Main.ss == SizeState.SIZE2x1) {
			return 2;
		}
		
		if(Main.ss == SizeState.SIZE4x4) {
			return 16;
		}
		
		return 0;
	}
	
	public static String getSize() {
		if(Main.ss == SizeState.SIZE8x1) {
			return "8x1";
		}
		if(Main.ss == SizeState.SIZE4x2) {
			return "4x2";
		}
		
		if(Main.ss == SizeState.SIZE4x4) {
			return "4x4";
		}
		
		if(Main.ss == SizeState.SIZE2x1) {
			return "2x1";
		}
		
		return "ERROER";
	}
	

}
