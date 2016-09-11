/**
 * 
 */

/**
 * @author Khyati K.Vyas
 *
 */
public class Link {

	public String bookname;
	public int dollarsEarned;

	public Link next;

	/**
	 * parameterized constructor
	 */
	public Link(String bookname, int dollarsEarned) {
		// TODO Auto-generated constructor stub
		this.bookname = bookname;
		this.dollarsEarned = dollarsEarned;
	}

	public void display() {
		System.out.print(bookname + " , " + dollarsEarned + ". ");
	}

	public String toString() {
		return bookname;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedList ll = new LinkedList();

		ll.insert("K", 10);
		ll.insert("B", 20);
		ll.insert("A", 30);
		ll.insert("D", 40);
		ll.insert("A", 10);
		ll.insert("E", 60);
		ll.insert("F", 10);
		ll.display();
		ll.delete();
		ll.findLink("A");
		ll.removeLink("A");
		ll.display();

	}

}

class LinkedList {
	public Link firstlink;

	LinkedList() {
		firstlink = null;
	}

	public boolean isEmpty() {
		if (firstlink == null) {
			System.out.println("Linked list is empty");
			return true;
		} else
			return false;
	}

	public void insert(String bookname, int dollarsEarned) {
		Link newlink = new Link(bookname, dollarsEarned);

		newlink.next = firstlink;
		firstlink = newlink;

	}

	/**
	 * Link is retured to update in the list.
	 * 
	 * @return the new firstlink
	 */
	public Link delete() {
		Link referencelink = firstlink;
		System.out.println("Deleting first link!!");
		if (!isEmpty()) {
			System.out.println(referencelink + " Deleted!!");
			/**
			 * firstlink is used since u return it to the main and the list is
			 	updated with the new first link
			 */
			 
			firstlink = firstlink.next;
		} else
			System.out.println("Linked list is empty");

		return referencelink;
	}

	public Link findLink(String findBook) {
		
		/**
		 * needs a new link so that changes to firstlink are not made.
		 */
		Link findlink=firstlink;
		System.out.println("Finding book... " + findBook);
		/**
		 *  check if linked list is empty or no.
		 */
		if (!isEmpty()) {
			/**
			 *  loop till firstlink is null to find multiple matches
			 */
			while (findlink.next != null) {
				if (findlink.bookname == findBook) {
					System.out.println(" Book found !! ");
					/**
					 *  this makes the next link firstlink to check if a match is 
					 *  found.without this only first match will be found
					 */
					
					findlink = findlink.next;
				} else
					/**
					 *  if first node dosent contain a match go to next node.
					 */
					findlink = findlink.next;
			}
			/**
			 *  if the last node pointing to null contains the book.
			 */
			if (findlink.next == null) {
				if (findlink.bookname == findBook) {
					System.out.println(" Book found !! ");
				}
			}
		}
		/**
		 *  Not required since sop is handled in isEmpty() already
		 *  else System.out.println("Linked list is empty!!");
		 */
		
			return findlink;
	}

	/**
	 * removes specified link
	 * 
	 * @param book:link
	 *            to be removed
	 * @return updated link after removal
	 */

	public Link removeLink(String book) {
		/**
		 * maintains the link to firstlink for display()
		 */
		Link updatedlink = firstlink;

		/**
		 * initialize the currentlink to thr first node and the previous link as
		 * null
		 */
		Link currentlink = updatedlink;
		Link previouslink = null;

		if (!isEmpty()) {
			if (currentlink.bookname == book) {
				/**
				 * checks if the node to be deleted is the first node.
				 */
				if (currentlink == updatedlink && previouslink == null) {
					System.out.println("Match found in the first node!");
					System.out.println("Deleting " + book);
					delete();
				}
			} else {
				/**
				 *  for other cases
				 */
				while (currentlink.next != null) {

					/**
					 * sets currentlink to the link pointing to the next node of  the first node.
					 */
					
					currentlink = updatedlink.next;
					/**
					 *  previous link now becomes the first node
					 */
					previouslink = updatedlink;
					/**
					 * keeps updating the updatedlist for iteration.
					 */
					updatedlink = updatedlink.next;

					if (currentlink.bookname == book)

					{
						if (currentlink.next != null) {
							System.out.println("Match found!!");
							System.out.println("Deleting " + book);
							/**
							 * breaks the link of the node to be deleted with the previous and next node.
							 */
							
							previouslink.next = currentlink.next;
							/**
							 *  current link is now the next node after the link that was deleted.
							 */
							currentlink = previouslink.next;

						} else {
							/**
							 *  for last node
							 */
							System.out.println("Match found at the last node!");
							System.out.println("Deleting " + book);
							/**
							 * sets the firstlink to null.therefore no linked list will exsist
							 */
								firstlink = null;
								System.out.println("Linked list is now empty!");
						}

					}
				}

			}
		}
		return updatedlink;
	}

	public void display() {
		Link thelink = firstlink;

		while (thelink != null) {
			thelink.display();
			System.out.println("Next link: " + thelink.next);
			thelink = thelink.next;
			System.out.println();

		}
	}

}