//complete singly linear
class node {
    public int data;
    public node next;

    // important
    public node(int no) {
        this.data = no;
        this.next = null;
    }
}

class Singlyll {
    private node first;
    private int iCount;

    Singlyll() {
        System.out.println("onject of singlyll gets created");
        this.first = null;
        this.iCount = 0;
    }

    public void InsertFirst(int no) {
        node newn = null;
        newn = new node(no); // changed code

        newn.next = this.first;
        this.first = newn;

        this.iCount++;
    }

    public void InsertLast(int no) {
        node newn = null;
        node temp = null;
        newn = new node(no); // changed code

        if (this.iCount == 0) {
            this.first = newn;
        } else {
            temp = this.first;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newn;
        }
        this.iCount++;
    }

    public void DeleteFirst() {
        if (this.first == null) {
            return;
        } else if (this.first.next == null) {
            this.first = null;

        } else {
            this.first = this.first.next;
        }
        System.gc();
        this.iCount--;

    }

    public void DeleteLast() {
        node temp = null;
        if (this.first == null) {
            return;
        } else if (this.first.next == null) {
            this.first = null;
            System.gc();
        } else {
            temp = this.first;

            while (temp.next.next != null) {
                temp = temp.next;

            }
            temp.next = null;
        }
        System.gc();
        this.iCount--;

    }

    public void Display() {
        node temp = null;
        temp = this.first;

        while (temp != null) {
            System.out.print("| " + temp.data + " |->");
            temp = temp.next;
        }
        System.out.println("\n");

    }

    public int count() {
        return this.iCount;
    }

    public void InsertAtPos(int no, int pos) {
        node temp = null;
        int iCnt = 0;
        node newn = null;
        if (pos < 1 || pos > this.iCount + 1) {
            System.out.println("invalid position");
            return;
        }
        if (pos == 1) {
            this.InsertFirst(no);
        } else if (pos == this.iCount + 1) {
            this.InsertLast(no);
        } else {
            newn = new node(no);
            temp = this.first;

            for (iCnt = 1; iCnt < pos - 1; iCnt++) {
                temp = temp.next;
            }
            newn.next = temp.next;
            temp.next = newn;

            this.iCount++;
        }
    }

    public void DeleteAtPos(int pos) {
        node temp = null;
        int iCnt = 0;
        if (pos < 1 || pos > this.iCount) {
            System.out.println("invalid position");
            return;
        }
        if (pos == 1) {
            this.DeleteFirst();
        } else if (pos == this.iCount) {
            this.DeleteLast();
        } else {
            temp = this.first;

            for (iCnt = 1; iCnt < pos - 1; iCnt++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            System.gc();
            this.iCount--;
        }
    }
}

class program448 {
    public static void main(String A[]) {
        Singlyll obj = null;

        int iRet = 0;

        obj = new Singlyll();

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

        obj.DeleteFirst();
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
