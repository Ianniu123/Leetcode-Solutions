class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        last = {}
        results = []
        for i, char in enumerate(s):
            last[char] = i
        
        first_idx = 0
        last_idx = last[s[0]]

        for i, char in enumerate(s):
            if i == last_idx:
                results.append(last_idx - first_idx + 1)
                first_idx = i + 1
                if (i + 1) < len(s):
                    last_idx = last[s[i + 1]]
            elif last[char] > last_idx:
                last_idx = last[char] 

        return results