//doubly linear

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

class DoublyLL {
    private node first;
    private int iCount;

    public DoublyLL() {
        System.out.println("Object of DoublyLL gets created");
        this.first = null;
        this.iCount = 0;
    }

    public void InsertFirst(int no) {
        node newn = null;
        newn = new node(no);

        newn.data = no;
        newn.next = null;
        newn.prev = null;

        if (this.first == null) {
            this.first = newn;
        } else {
            newn.next = this.first;
            this.first = newn;
            newn.next.prev = newn;
        }

        this.iCount++;
    }

    public void InsertLast(int no) {
        node temp = null;
        node newn = null;
        newn = new node(no);

        newn.data = no;
        newn.next = null;
        newn.prev = null;

        if (this.first == null) {
            this.first = newn;
        } else {
            temp = this.first;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newn;
            newn.prev = temp;
        }

        this.iCount++;
    }

    public void InsertAtPos(int no, int pos) {
        node temp = null;
        int iCnt = 0;

        if (pos < 1 || pos > iCount + 1) {
            System.out.println("Invalid position");
            return;
        }
        if (pos == 1) {
            this.InsertFirst(no);
        } else if (pos == iCount + 1) {
            this.InsertLast(no);
        } else {
            temp = this.first;
            node newn = null;
            newn = new node(no);

            newn.data = no;
            newn.next = null;
            newn.prev = null;

            for (iCnt = 1; iCnt < pos - 1; iCnt++) {
                temp = temp.next;
            }
            newn.next = temp.next;
            newn.next.prev = newn;

            temp.next = newn;
            newn.prev = temp;

            this.iCount++;
        }
    }

    public void DeleteFirst() {
        if (this.first == null) {
            return;
        } else if (this.first.next == null) {
            this.first = null;
        } else {
            this.first = this.first.next;
            this.first.prev = null;
        }

        this.iCount--;
    }

    public void DeleteLast() {
        node temp = null;

        if (this.first == null) {
            return;
        } else if (this.first.next == null) {
            this.first = null;
        } else {
            temp = this.first;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
        }

        this.iCount--;
    }

    public void DeleteAtPos(int pos) {
        node temp = null;
        int iCnt = 0;

        if (pos < 1 || pos > iCount) {
            System.out.println("Invalid position");
            return;
        }
        if (pos == 1) {
            DeleteFirst();
        } else if (pos == iCount) {
            DeleteLast();
        } else {
            temp = this.first;
            for (iCnt = 1; iCnt < pos - 1; iCnt++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            temp.next.prev = temp;

            this.iCount--;
        }
    }

    public void Display() {
        node temp = null;
        temp = first;

        while (temp != null) {
            System.out.print(" | " + temp.data + " | <=>");
            temp = temp.next;
        }
        System.out.println();
    }

    public int Count() {
        return this.iCount;
    }
}

class program450 {
    public static void main(String A[]) {
        int iRet = 0;
        DoublyLL obj = null;
        obj = new DoublyLL();

        obj.InsertFirst(51);
        obj.InsertFirst(21);
        obj.InsertFirst(11);

        obj.Display();

        iRet = obj.Count();
        System.out.println("Number of nodes are: " + iRet);

        obj.InsertLast(101);
        obj.InsertLast(111);
        obj.InsertLast(121);

        obj.Display();

        iRet = obj.Count();
        System.out.println("Number of nodes are: " + iRet);

        obj.DeleteFirst();

        obj.Display();

        iRet = obj.Count();
        System.out.println("Number of nodes are: " + iRet);

        obj.DeleteLast();

        obj.Display();

        iRet = obj.Count();
        System.out.println("Number of nodes are: " + iRet);

        obj.InsertAtPos(105, 2);

        obj.Display();

        iRet = obj.Count();
        System.out.println("Number of nodes are: " + iRet);

        obj.DeleteAtPos(2);

        obj.Display();

        iRet = obj.Count();
        System.out.println("Number of nodes are: " + iRet);

        // Important for memory deallocation
        obj = null;
        System.gc();
    }
}