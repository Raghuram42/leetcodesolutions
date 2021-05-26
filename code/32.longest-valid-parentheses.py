class Solution(object):
   def longestValidParentheses(self, s):
      stack = [-1]
      ans = 0
      for i in range(len(s)):
         if s[i] == "(":
            stack.append(i)
         else:
            if stack and stack[-1]!=-1 and s[stack[-1]] == "(":
               stack.pop()
               ans = max(ans,i - stack[-1])
            else:
             stack.append(i)
      return ans