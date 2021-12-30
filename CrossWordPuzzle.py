def readInts(): return map(int, input().strip().split())

def make_sets(cs):
    rows = len(cs)
    cols = len(cs[0])
    out_sets = set()
    visited = set()
    for sr in range(rows):
        for sc in range(cols):            
            if cs[sr][sc] != "-": continue
            if sc==0 or cs[sr][sc-1] != "-":
                # right            
                c = sc
                while c < cols and cs[sr][c] == "-":
                    visited.add( (sr,c) )
                    c += 1
                if c-1 > sc: out_sets.add( ((sr,sc), c-sc, (0,1)) )
            if sr==0 or cs[sr-1][sc] != "-":
                # down
                r = sr
                while r < rows and cs[r][sc] == "-":
                    visited.add( (r,sc) )
                    r += 1
                if r-1 > sr: out_sets.add( ((sr,sc), r-sr, (1,0)) )
    return out_sets

def solve_sets(ss,ws,used):
    def addt(a,b):
        ar,ac = a
        br,bc = b
        return (ar+br,ac+bc)
    if not ws: return used
    w = ws.pop()
    for (src,size,dd) in ss:
        if len(w) != size: continue
        rc = src
        ok = True
        for d in range(size):
            if rc in used and used[rc]!=w[d]:
                ok = False
                break
            rc = addt(rc,dd)
        if not ok: continue
        used2 = dict(used)
        rc = src
        for d in range(size):
            used2[rc] = w[d]
            rc = addt(rc,dd)
        ss2 = set(ss)
        ss2.remove( (src,size,dd) )
        attempt = solve_sets(ss2,ws,used2)
        if attempt: return attempt
    ws.append(w)
    return None

cs = [ input().strip() for _ in range(10) ]
ws = input().strip().split(";")
ss = make_sets(cs)
sol = solve_sets(ss,ws,dict())
rows = len(cs)
cols = len(cs[0])

for r in range(rows):
    a = []
    for c in range(cols):
        if (r,c) in sol: a.append(sol[ (r,c) ])
        else: a.append(cs[r][c])
    print("".join(a))
                    


