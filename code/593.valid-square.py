class Solution:
    def validSquare(self, p1: List[int], p2: List[int], p3: List[int], p4: List[int]) -> bool:
        
        point = [p1, p2, p3, p4]
        
        edge_length = set()
        
        # lambda to compute edge length between point pair
        get_length = lambda a, b: ( (a[0] - b[0]) ** 2 + (a[1] - b[1]) ** 2 ) ** 0.5
        
        # check each point pair
        for i in range(3):
            for j in range(i+1,4):
                
                cur_length = get_length(point[i], point[j])
                
                if cur_length == 0:
                    # Reject when any two points are repeated
                    return False
                
                edge_length.add( cur_length )
                

        # Accept if only two kinds of edges length, one is side length, the other is diagonal length
        return len(edge_length) == 2
