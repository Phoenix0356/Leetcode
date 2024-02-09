class Solution:
    def rangeSum(self, nums: List[int], n: int, left: int, right: int) -> int:
        sums = list(nums)
        mod = 1000000007
        for i, num in enumerate(nums):
            pre = num
            for j in range(i + 1, len(nums)):
                pre += nums[j]
                sums.append(pre)
        sums.sort()
        ans = sum(sums[left - 1:right])
        return ans % mod