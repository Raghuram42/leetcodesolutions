class Solution(object):
    def removeStones(self, stones):
        # graph: connected component
        
        # init
        comp = collections.defaultdict(int) # components
        col = collections.defaultdict(list) # column of stones
        S = collections.defaultdict(int) # for component counting
        
        for y, x in stones:
            comp[y] = y # first label the component by rows
            col[x].append(y) # collect columns
        
        # find unions
        def p(i): #p: parent
            if comp[i] == i:
                return i
            comp[i] = p(comp[i]) # finding-parent trick: update parents in searching!
            return comp[i]
            
        for x in col:
            y_c = min(col[x])
            #y_c = col[x][0] # this choice is also fine
            if y_c in comp: # y_c has been labeled
                y_c = p(y_c) # find its ancestor
                
            for y in col[x]:
                if y not in comp:
                    comp[y] = y_c
                else:
                    comp[p(y)] = y_c
        
        # count
        for y, x in stones:
            S[p(y)] += 1 # count elm in each component
            
        tot = 0
        for x in S:
            tot += S[x] - 1
        
        return tot