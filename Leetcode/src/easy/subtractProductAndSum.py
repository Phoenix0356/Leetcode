class Solution:
    def subtractProductAndSum(self, n: int) -> int:
        sum_ = 0
        prod = 0
        while n > 0:
            temp = n % 10
            n /= 10
            sum_ += temp
            prod *= temp

        return prod - sum_
