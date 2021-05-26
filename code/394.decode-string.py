class Solution:
    def decodeString(self, s: str) -> str:
        n = len(s)
        stack = []
        for c in s:
            if c == ']':
                # the chars between [ and ] 
                tmp = ""
                while stack[-1] != '[':
                    tmp = stack.pop() + tmp
                
                # pop the [
                stack.pop()
                
                # calculate the times
                times = ""
                while stack and '0' <= stack[-1] <= '9':
                    times = stack.pop() + times
                times = int(times)
                
                # push into stack as a usual char
                stack.append(tmp * times)
            
            else:
                stack.append(c)
        
        return "".join(stack)