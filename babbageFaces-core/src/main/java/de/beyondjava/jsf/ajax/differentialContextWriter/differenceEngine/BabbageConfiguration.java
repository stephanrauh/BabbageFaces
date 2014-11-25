/**
 *  (C) 2013-2014 Stephan Rauh http://www.beyondjava.net
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */package de.beyondjava.jsf.ajax.differentialContextWriter.differenceEngine;

/**
 * Configuration of BabbageFaces. Contains flags needed to fine-tune
 * BabbageFaces.
 */
public class BabbageConfiguration {
	public static final String VERSION = "1.0 RC2";

	/**
	 * If the application runs on Apache MyFaces, we can detect the end of the
	 * HTML stream a lot simpler and faster than on Mojarra
	 */
	public static boolean isMyFaces = false;
	static {
		try {
			Class.forName("org.apache.myfaces.application.ApplicationImpl");
			isMyFaces = true;
			// MyFaces uses an older format of the insert command,
			// so we switch it off provisionally
			useInsertStatements = false;
		} catch (ClassNotFoundException e) {
			isMyFaces = false; // activates Mojarra support
		}
	}

	/**
	 * If true, BabbageFaces never generates a sequence of response statements
	 * that need more bytes than the original sequence. If optimizeSize is set
	 * to false, the response tends to be bigger, but the user experience
	 * usually is smoother (less cursor focus losses etc., less flicker on
	 * browsers lacking double buffering, possibly even more speed).
	 */
	private static boolean optimizeSize = false;

	/**
	 * Is BabbageFaces allowed to use insert command in the response? Inserts can optimize the response considerably,
	 * but cause many incompatibilities. Plus, JSF 2.2 introduced a new syntax of the insert command that's not
	 * supported by MyFaces.
	 */
	private static boolean useInsertStatements = false;

	public static boolean isUseInsertStatements() {
		return useInsertStatements;
	}

	/**
	 * If true, IDs are replaced by shorter IDs. Only applies to IDs generated
	 * by BabbageFaces (because other IDs might be used by external Javascript
	 * files which can't be modified by BabbageFaces).
	 */
	private static boolean optimizeSyntheticIDsAggressively = true;

	/**
	 * If true, IDs are replaced by shorter IDs. Only applies to IDs generated
	 * by BabbageFaces (because other IDs might be used by external Javascript
	 * files which can't be modified by BabbageFaces).
	 */
	public static boolean isOptimizeSyntheticIDsAggressively() {
		return optimizeSyntheticIDsAggressively;
	}

	/**
	 * If true, IDs are replaced by shorter IDs. Only applies to IDs generated
	 * by BabbageFaces (because other IDs might be used by external Javascript
	 * files which can't be modified by BabbageFaces).
	 */
	public static void setOptimizeSyntheticIDsAggressively(
			boolean optimizeSyntheticIDsAggressively) {
		BabbageConfiguration.optimizeSyntheticIDsAggressively = optimizeSyntheticIDsAggressively;
	}

	/**
	 * If true, BabbageFaces never generates a sequence of response statements
	 * that need more bytes than the original sequence. If optimizeSize is set
	 * to false, the response tends to be bigger, but the user experience
	 * usually is smoother (less cursor focus losses etc., less flicker on
	 * browsers lacking double buffering, possibly even more speed).
	 */
	public static boolean isOptimizeSize() {
		return optimizeSize;
	}

}
