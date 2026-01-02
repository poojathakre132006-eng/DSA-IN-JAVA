//doubly circular
class node {
    public int data;
    public node next;
    public node prev;

    public node(int no) {
        this.data = no;
        this.next = null;
        this.prev = null;

    }
}

class Doublycl {
    private node first;
    private node last;
    private int iCount;

    Doublycl() {
        this.first = null;
        this.last = null;
        this.iCount = 0;
    }

    public void InsertFirst(int no) {
        node newn = new node(no);

        if (first == null) {
            first = newn;
            last = newn;
        } else {
            newn.next = first;
            first.prev = newn;
            first = newn;
        }

        last.next = first;
        first.prev = last;
        iCount++;
    }

    public void InsertLast(int no) {
        node newn = new node(no);

        if (first == null) {
            first = newn;
            last = newn;
        } else {
            last.next = newn;
            newn.prev = last;
            last = newn;
        }
        last.next = first;
        first.prev = last;
        iCount++;
    }

    public void DeleteFirst() {
        if (iCount == 0)
            return;

        if (iCount == 1) {
            first = null;
            last = null;
        } else {
            first = first.next;
            last.next = first;
            first.prev = last;
        }
        iCount--;
    }

    public void DeleteLast() {
        if (iCount == 0)
            return;

        if (iCount == 1) {
            first = null;
            last = null;
        } else {
            last = last.prev;
            last.next = first;
            first.prev = last;
        }
        iCount--;
    }

    public void Display() {
        if (first == null)
            return;

        node temp = first;

        do {
            System.out.print("| " + temp.data + " |<=>");
            temp = temp.next;
        } while (temp != first);
        System.out.println("\n");
    }

    public int count() {
        return this.iCount;
    }

    public void InsertAtPos(int no, int pos) {

        if (pos < 1 || pos > iCount + 1) {
            System.out.println("Invalid position");
            return;
        }

        if (pos == 1) {
            InsertFirst(no);
        } else if (pos == iCount + 1) {
            InsertLast(no);
        } else {
            node newn = new node(no);
            node temp = this.first;

            for (int i = 1; i < pos - 1; i++) {
                temp = temp.next;
            }

            newn.next = temp.next;
            newn.next.prev = newn;

            temp.next = newn;
            newn.prev = temp;

            this.iCount++;
        }
    }

    public void DeleteAtPos(int pos) {
        if (pos < 1 || pos > iCount) {
            System.out.println("Invalid position");
            return;
        }

        if (pos == 1) {
            DeleteFirst();
        } else if (pos == iCount) {
            DeleteLast();
        } else {
            node temp = this.first;

            for (int i = 1; i < pos - 1; i++) {
                temp = temp.next;
            }

            temp.next = temp.next.next;
            temp.next.prev = temp;

            this.iCount--;
        }
    }
}

class program449 {
    public static void main(String A[]) {
        Doublycl obj = null;

        int iRet = 0;

        obj = new Doublycl();

        obj.InsertFirst(51);
        obj.InsertFirst(21);
        obj.InsertFirst(11);

        obj.Display();
        iRet = obj.count();

        System.out.println("number of nodes are:" + iRet);

        obj.InsertLast(101);
        obj.InsertLast(111);
        obj.InsertLast(121);
        obj.Display();
        iRet = obj.count();

        System.out.println("number of nodes are:" + iRet);

        obj.DeleteLast();
        obj.Display();
        iRet = obj.count();

        System.out.println("number of nodes are:" + iRet);

        obj.InsertAtPos(105, 4);
        obj.Display();
        iRet = obj.count();

        System.out.println("number of nodes are:" + iRet);

        obj.DeleteAtPos(4);
        obj.Display();
        iRet = obj.count();

        System.out.println("number of nodes are:" + iRet);

        // important of deallocation
        obj = null;
        System.gc();

    }
}
