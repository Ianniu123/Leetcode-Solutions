class Solution(object):
    def minWindow(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """
        freq = Counter(t)
        count = 0
        min_l, min_length = None, None
        l = 0
        for r in range(len(s)):
            if s[r] not in freq:
                continue
            freq[s[r]] -= 1
            if freq[s[r]] >= 0:
                count += 1

            while count == len(t):
                if min_length == None or r - l + 1 < min_length:
                    min_l = l
                    min_length = r - l + 1

                if s[l] in freq:
                    freq[s[l]] += 1
                    if freq[s[l]] > 0:
                        count -= 1
                l += 1

        return "" if min_length is None else s[min_l: min_l + min_length]
        