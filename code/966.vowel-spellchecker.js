const regex = /[aeiou]/g
var spellchecker = function(W, Q) {
    let orig = new Set(W), lower = new Map(), mask = new Map()
    for (let i = W.length - 1; ~i; i--) {
        let word = W[i], wlow = word.toLowerCase()
        lower.set(wlow, word)
        mask.set(wlow.replace(regex, "*"), word)
    }
    for (let i in Q) {
        let query = Q[i], qlow = query.toLowerCase(),
            qmask = qlow.replace(regex, "*")
        if (orig.has(query)) continue
        else Q[i] = lower.get(qlow) || mask.get(qmask) || ""
    }
    return Q
};
