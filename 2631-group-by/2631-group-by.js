/**
 * @param {Function} fn
 * @return {Object}
 */
Array.prototype.groupBy = function(fn) {
    map = {}
    // console.log(this)
    
    for(let i=0;i<this.length;i++){
        let key = fn(this[i])
        if(!(key in map)){
            map[key] = []
        }
        map[key].push(this[i])
        
    }
    return map
    
};

/**
 * [1,2,3].groupBy(String) // {"1":[1],"2":[2],"3":[3]}
 */