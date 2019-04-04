// https://leetcode.com/problems/subdomain-visit-count/submissions/

// * use  map.merge(dom, count, (a, b) -> a + b) function, which is an awesome combination of putIfAbset() and getOrDefault()
// * use string.indexOf('.') and then substring(), which is much faster than .contains("//.") or .split("//.")

package leetcode;

public class SubdomainVisitCount {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String d : cpdomains){
            String dom = d.split(" ")[1];
            int count = Integer.parseInt(d.split(" ")[0]);
            map.merge(dom, count, (a, b) -> a + b);
            
            while(dom.indexOf('.') > 0){
                dom = dom.substring(dom.indexOf('.') + 1);
                map.merge(dom, count, (a, b) -> a + b);
            }
        }
        
        return map.keySet().stream().map(k -> map.get(k) + " " + k).collect(Collectors.toList());
    }
}
