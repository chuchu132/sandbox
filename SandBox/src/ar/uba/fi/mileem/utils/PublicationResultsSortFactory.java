package ar.uba.fi.mileem.utils;

import java.util.Comparator;

import ar.uba.fi.mileem.models.PublicationResult;

public class PublicationResultsSortFactory {

	private static final Comparator<PublicationResult> _sortByPriceAsc = new Comparator<PublicationResult>() {
		public int compare(PublicationResult lhs, PublicationResult rhs) {
			return lhs.getPrice().compareTo(rhs.getPrice());
		};
	};

	private static final Comparator<PublicationResult> _sortByPriceDesc = new Comparator<PublicationResult>() {
		public int compare(PublicationResult lhs, PublicationResult rhs) {
			return (lhs.getPrice().compareTo(rhs.getPrice())) * -1;
		};
	};

	private static final Comparator<PublicationResult> _sortByRecentPublicationDate = new Comparator<PublicationResult>() {
		public int compare(PublicationResult lhs, PublicationResult rhs) {
			return (lhs.getPublicationDate()
					.compareTo(rhs.getPublicationDate())) * -1;
		}
	};

	private static final Comparator<PublicationResult> _sortHighlightedFirst = new Comparator<PublicationResult>() {
		public int compare(PublicationResult lhs, PublicationResult rhs) {
			return (lhs.isHighlighted().compareTo(rhs.isHighlighted())) * -1;
		};
	};

	public static final Comparator<PublicationResult> getSortByPrice(boolean asc) {
		if (asc) {
			return _sortByPriceAsc;
		} else {
			return _sortByPriceDesc;
		}
	}

	public static final Comparator<PublicationResult> getSortByRecentPublicationDate() {
		return _sortByRecentPublicationDate;
	}

	public static final Comparator<PublicationResult> getSortHighlightedFirst() {
		return _sortHighlightedFirst;
	}

}
