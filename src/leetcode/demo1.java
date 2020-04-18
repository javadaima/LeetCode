package leetcode;

import org.junit.Test;

import java.util.LinkedList;

public class demo1 {


    /*
    * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
    如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
    您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
    示例：
    输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
    输出：7 -> 0 -> 8
    原因：342 + 465 = 807
    * */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode aideNode = new ListNode(0);//只做辅助用
        ListNode resultNode = aideNode;//结果
        int carry = 0;//进位标记
        do{
            int val1 = l1 == null ? 0:l1.val;
            int val2 = l2 == null ? 0:l2.val;
            if(val1+val2+carry >= 10){
                resultNode.next = new ListNode(val1+val2+carry - 10);
                carry = 1;
            }else{
                resultNode.next = new ListNode(val1+val2+carry);
            }
            resultNode = resultNode.next;

            if(l1!= null){
                l1 = l1.next;
            }
            if(l2!= null){
                l2 = l2.next;
            }

        }while(l1!= null || l2 != null );

        if(carry == 1){
            resultNode.next = new ListNode(1);
        }

        return aideNode.next;
    }

    @Test
    public void test1() {

        ListNode listNode1 = new ListNode(2);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(3);
        ListNode listNode2 = new ListNode(5);
        listNode2.next = new ListNode(6);
        listNode2.next.next = new ListNode(4);
        ListNode listNode = addTwoNumbers(listNode1, listNode2);
        System.out.println(123);

        LinkedList<String> strings = new LinkedList<>();
        strings.add("ceshi1");
        strings.add("ceshi2");
        strings.add("ceshi3");
        strings.add("ceshi4");
        System.out.println(123);



    }
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

}
