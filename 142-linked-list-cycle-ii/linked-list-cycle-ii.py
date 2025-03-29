# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def detectCycle(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """

        slow = head
        fast = head
        is_first_cycle = True

        while fast != slow or is_first_cycle:
            if fast is None or fast.next is None:
                return None
            fast = fast.next.next
            slow = slow.next
            is_first_cycle = False

        fast = head
        while fast != slow:
            fast = fast.next
            slow = slow.next

        return fast
        