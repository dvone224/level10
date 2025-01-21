package _12콜랙션멤버;

import java.util.Comparator;

public class MemberComp implements Comparator<Member> {
	enum SortBy {
		NAME, ID
	}

	private SortBy sortBy;

	MemberComp(SortBy sortBy) {
		this.sortBy = sortBy;
	}

	@Override
	public int compare(Member o1, Member o2) {
		int result = 0;
		switch (sortBy) {
		case NAME:
			result = o1.getName().compareTo(o2.getName());
			break;
		case ID:
			result = o1.getId().compareTo(o2.getId());
			break;
		}
		return result;
	};
}
