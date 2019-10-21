package net.noprefix.bedwars.Manager.GameManager;

import java.util.ArrayList;

import net.noprefix.bedwars.States.SizeState;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import net.noprefix.bedwars.Main.Main;

public class TeamManager {
	
	public static ArrayList<Player> teamBlau = new ArrayList<>();
	public static ArrayList<Player> teamRot = new ArrayList<>();
	public static ArrayList<Player> teamGelb = new ArrayList<>();
	public static ArrayList<Player> teamGruen = new ArrayList<>();
	
	public static ArrayList<Player> teamLila = new ArrayList<>();
	public static ArrayList<Player> teamSchwarz = new ArrayList<>();
	public static ArrayList<Player> teamTurkis = new ArrayList<>();
	public static ArrayList<Player> teamOrange = new ArrayList<>();
	
	public static Boolean bedBlau = true;
	public static Boolean bedRot = true;
	public static Boolean bedGelb = true;
	public static Boolean bedGruen = true;
	
	public static Boolean bedLila = true;
	public static Boolean bedSchwarz = true;
	public static Boolean bedTurkis = true;
	public static Boolean bedOrange = true;
	

	public static void clear(Player p) {
		if(teamBlau.contains(p)) {
			teamBlau.remove(p);
		}else if(teamRot.contains(p)) {
			teamRot.remove(p);
		}else if(teamGelb.contains(p)) {
			teamGelb.remove(p);
		}else if(teamGruen.contains(p)) {
			teamGruen.remove(p);
		}else if(teamLila.contains(p)) {
			teamLila.remove(p);
		}else if(teamSchwarz.contains(p)) {
			teamSchwarz.remove(p);
		}else if(teamTurkis.contains(p)) {
			teamTurkis.remove(p);
		}else if(teamOrange.contains(p)) {
			teamOrange.remove(p);
		}
		
	}
	
	public static String getTeam(Player p) {
		if(teamBlau.contains(p)) {
			return "§9§lBlau";
		}else if(teamRot.contains(p)) {
			return "§c§lRot";
		}else if(teamGelb.contains(p)) {
			return "§e§lGelb";
		}else if(teamGruen.contains(p)) {
			return "§2§lGrün";
		}else if(teamLila.contains(p)) {
			return "§5§lLila";
		}else if(teamSchwarz.contains(p)) {
			return "§0§lSchwarz";
		}else if(teamTurkis.contains(p)) {
			return "§b§lTurkis";
		}else if(teamOrange.contains(p)) {
			return "§6§lOrange";
		}
		
		return "§c§l✘";
	}
	
	public static String getTeamColors(Player p) {
		if(teamBlau.contains(p)) {
			return "§9§l";
		}else if(teamRot.contains(p)) {
			return "§c§l";
		}else if(teamGelb.contains(p)) {
			return "§e§l";
		}else if(teamGruen.contains(p)) {
			return "§2§l";
		}else if(teamLila.contains(p)) {
			return "§5§l";
		}else if(teamSchwarz.contains(p)) {
			return "§0§l";
		}else if(teamTurkis.contains(p)) {
			return "§b§l";
		}else if(teamOrange.contains(p)) {
			return "§6§l";
		}
		
		return "§7";
	}
	
	public static void getTeamVULL() {
		for(Player all : Bukkit.getOnlinePlayers()) {
			if(Main.ss == SizeState.SIZE8x1) {
			if(!teamBlau.contains(all)) {
				if(!teamRot.contains(all)) {
					if(!teamGelb.contains(all)) {
						if(!teamGruen.contains(all)) {
							if(!teamLila.contains(all)) {
								if(!teamSchwarz.contains(all)) {
									if(!teamTurkis.contains(all)) {
										if(!teamOrange.contains(all)) {
											if(teamBlau.size() == 1) {
												if(teamRot.size() == 1) {
													if(teamGelb.size() == 1) {
														if(teamGruen.size() == 1) {
															if(teamLila.size() == 1) {
																if(teamSchwarz.size() == 1) {
																	if(teamOrange.size() == 1) {
																		if(teamTurkis.size() == 1) {
																			
																		}else {
																			teamTurkis.add(all);
																		}
																	}else {
																		teamOrange.add(all);
																	}
																}else {
																	teamSchwarz.add(all);
																}
															}else {
																teamLila.add(all);
															}
														}else {
															teamGruen.add(all);	
														}
													}else {
														teamGelb.add(all);
													}
												}else {
													teamRot.add(all);
												}
											}else {
												teamBlau.add(all);
											}
											
											
										}
									}
								}
							}
						}
					}
				}
			}
			}else if(Main.ss == SizeState.SIZE4x2) {
				
				if(!teamBlau.contains(all)) {
					if(!teamRot.contains(all)) {
						if(!teamGelb.contains(all)) {
							if(!teamGruen.contains(all)) {
								if(teamBlau.size() == 2) {
									if(teamRot.size() == 2) {
										if(teamGelb.size() == 2) {
											if(teamGruen.size() == 2) {
											}else {
												teamGruen.add(all);	
											}
										}else {
											teamGelb.add(all);	
										}
									}else {
										teamRot.add(all);	
									}
								}else {
									teamBlau.add(all);	
								}
							}
						}
					}
				}
			}else if(Main.ss == SizeState.SIZE2x1) {
				if(!teamBlau.contains(all)) {
					if(!teamRot.contains(all)) {
						if(teamBlau.size() == 1) {
							if(teamRot.size() == 1) {
								
								
							}else {
								teamRot.add(all);	
							}
						}else {
							teamBlau.add(all);	
						}
					}
				}
			}
		}
		
	}
		public static void checkBedTeams() {
			if(teamBlau.size() == 0) {
				bedBlau = false;
			}
			if(teamRot.size() == 0) {
				bedRot = false;
			}
			
			if(teamGelb.size() == 0) {
				bedGelb = false;
			}
			
			if(teamGruen.size() == 0) {
				bedGruen = false;
			}
			
			if(teamTurkis.size() == 0) {
				bedTurkis = false;
			}
			if(teamSchwarz.size() == 0) {
				bedSchwarz = false;
			}
			
			if(teamOrange.size() == 0) {
				bedOrange = false;
			}
			
			if(teamLila.size() == 0) {
				bedLila = false;
			}
		}
		
	
}
