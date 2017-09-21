package net.gnu.util;

import java.io.File;
import java.util.Comparator;
import android.util.*;

public class SortFileSizeIncrease implements Comparator<File> {
	@Override
	public int compare(final File p1, final File p2) {
//		if (p1.isFile() == p1.isDirectory()) {
//			Log.d("SortFileSizeIncrease", p1.getAbsolutePath());
//		}
		if (!p1.isDirectory() && !p2.isDirectory()) {
			final long length1 = p1.length();
			final long length2 = p2.length();
			if (length1 < length2) {
				return -1;
			} else if (length1 > length2) {
				return 1;
			} else {
				return (int)(length1 - length2);
			}
		} else if (p1.isDirectory() && p2.isDirectory()) {
			final String[] list1 = p1.list();
			final int length1 = ((list1 == null) ? 0 : list1.length);
			final String[] list2 = p2.list();
			final int length2 = ((list2 == null) ? 0 : list2.length);
			return (length1 - length2);
		} else if (!p1.isDirectory() && p2.isDirectory()) {
			return 1;
		} else {
			return -1;
		}
	}
}

