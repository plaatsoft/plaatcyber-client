/**
 *  @file
 *  @brief 
 *  @author wplaat
 *
 *  Copyright (C) 2008-2016 PlaatSoft
 *
 *  This program is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, version 3.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

package nl.plaatsoft.cyber.tools;

import nl.plaatsoft.cyber.model.ElementLevel;

public class Constants {

	public final static String APP_NAME = "CyberWar";
	public final static String APP_VERSION = "0.1";
	public final static String APP_BUILD = "Build (31-07-2017)";
	
	public final static String APP_WS_NAME = "Java-CyberWar";
	public final static String APP_WS_URL = "https://service.plaatsoft.nl";
	public final static String APP_DONATE_URL = "http://www.plaatsoft.nl/donate";
	
	public final static int BORDER_SIZE = 35;
	public final static int WIDTH = 1080;
	public final static int HEIGHT = 720;	
	
	public static final int NODE_WIDTH = 160;
	public static final int NODE_HEIGHT = 60;
	
	public static final int INIT_MONEY = 100;
	public static final int INIT_BCOIN = 100;
	public static final int INIT_GOLD = 100;
	public static final int INIT_LEVEL = 1;
	public static final int INIT_THREAD = 1;
	
	public static final ElementLevel MAX_NODE_LEVEL = ElementLevel.FIVE;
}
