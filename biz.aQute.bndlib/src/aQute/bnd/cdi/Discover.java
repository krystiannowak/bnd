package aQute.bnd.cdi;

import java.util.EnumSet;

public enum Discover {
	all,
	annotated,
	annotated_by_bean,
	none;

	static void parse(String s, EnumSet<Discover> options, CDIAnnotations state) {
		if (s == null)
			return;
		boolean negation = false;
		if (s.startsWith("!")) {
			negation = true;
			s = s.substring(1);
		}
		Discover option = Discover.valueOf(s);
		if (negation) {
			options.remove(option);
		} else {
			options.add(option);
		}
	}
}