class Solution:

    def waysToBuyPensPencils(self, total: int, cost1: int, cost2: int) -> int:
        if cost1 < cost2:
            temp = cost1
            cost1 = cost2
            cost2 = temp

        res, cnt = 0, 0
        while cnt * cost1 <= total:
            res += (total - cnt * cost1) / cost2 + 1
            cnt += 1

        return res
