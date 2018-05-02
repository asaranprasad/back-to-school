//https://leetcode.com/problems/palindrome-pairs/description/
package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PalindromePairs {

  public List<List<Integer>> palindromePairs(String[] words) {
    List<List<Integer>> ret = new ArrayList<List<Integer>>();
    for (int i = 0; i < words.length; i++) {
      for (int j = 0; j < words.length; j++) {
        if (i != j) {
          if (isPalindrome(words[i] + words[j])) {
            List<Integer> pair = new ArrayList<Integer>();
            pair.add(i);
            pair.add(j);
            ret.add(pair);
          }
        }
      }
    }
    return ret;
  }

  private boolean isPalindrome(String s) {
    StringBuilder sb = new StringBuilder();
    sb.append(s);
    return sb.reverse().toString().equals(s);
  }

  public static void main(String args[]) {
    String[] words1 = {"abcd", "dcba", "lls", "s", "sssll"};
    printResults(words1);
    String[] words2 = {"jhcfidbhfgcfibd", "hicdeiadibhedccih", "ddeeiigdce", "d",
        "ehaddhh", "e", "jch", "gi", "eihjbggcjgdigjjejf", "cghdihihjbfbfbghg",
        "chbjihdbhijcd",
        "bjfhihdacggjejd", "jiddjaddac", "bacgejbeeg", "bchechbfdccficj",
        "aidgggedgjajdeg", "g", "dedf", "ecahgg", "aebiaebgeahabbegf",
        "icegehifadjejigaaeb", "bfejbheia", "hcfidbfdidhhbbbgj", "dcagh", "jegfiedjieia",
        "ibhicjihhacgfaa", "deaejchfiighbahfcadi", "cbbficbfj", "dgjichecijfgffcb",
        "ghdfgjiihgcegagjc", "ecaediahcgcjfji", "gcjicjhdhgajfg", "bidijahbhi",
        "bbiiebijjeijb", "hcagjcafeichc", "hcd", "aacgjg", "ajdjijjiehcjjijgaeha",
        "hjjcheiicdihiaiaja", "hecfgaieddijdeifi", "j", "f", "fbjdebihf", "ehgc", "jgdaa",
        "effhecjfehfecfh", "dbfhcjff", "ihbdfgebg", "jibdaaieehj", "ahaddbfgdeci",
        "cibjcf", "fcdajjddjchej", "gbhbabfgiggjfajade", "idbcghc", "adbg",
        "hbdbdbebbbfage", "c", "iicbiebjegdh", "dafbeedhcajiihjfa", "gihbbeacedddh",
        "fejhhigigjcbi", "ebhfb", "bdbf", "gagcffajh", "acbgifcjegihbje", "bbabbbfeefhfd",
        "eji", "jjibabbcjihj", "caa", "h", "fbi", "hbgaded", "hafe", "aahfajbeeaab",
        "iidfggjfgd", "dijaabbehcfhje", "b", "fg", "gjijhacihh", "iabieibecfhhijjgh",
        "acdgfdjbfbib", "aci", "bhaeeiacb", "bcdb", "jj", "eddgfbcjeg", "baffbhijaij",
        "idighfidhdjij", "gd", "faj", "ebdjfagdhceea", "ggdfgihd", "dhaafcdddgi", "ajji",
        "bbdhbdd", "dajchdhbaafb", "ffbaagejh", "dabace", "jfcggdjeifdiaghiij",
        "gcdgdfbfiiegdcej", "jhfheicafifbbah", "egjajdehdbhjabj", "hgbdheifebdidciifdfa",
        "diadcahdccbf", "hjeacfcfcgcfadieh", "jgdejaeajfibcgeigga", "hbceggffehfhf",
        "jbcdfc", "ahi", "bhadj", "cgjgb", "efbadieeafdgdcfiaig", "daeedhjccagah",
        "bfejgijbbjeg", "fdjfeejijbchfchhahhd", "ibadjfacbcbafh", "idedeibg",
        "igdjjfbfibebdabijgc", "bjji", "bijgbdidffaafaacaec", "dgbefibfadb", "ccjcecihf",
        "cgjghgcdiagaic", "fbhicbeccd", "aae", "aaicgihifbbefbde", "hcfcfcfbeaifafcaddh",
        "hajidbebbg", "feief", "ajdhfafagid", "fba", "hbdciicbhfifebhichhf",
        "behhajhhbgg", "ghgffacagbhdf", "fhdhff", "edfa", "cjbhcab", "bjcjeeeacg",
        "dbjigagbjegc", "igeefhehijgiciji", "fgfibjfefjeahbcacea", "hfceeifcgaaehd", "ge",
        "bcigbegbdieifihgjdg", "icdfagbcd", "abhijeedhfbghbjdfb", "fgfjbg",
        "ejbjjdhejfcdeha", "didcjff", "bfhdchadc", "i", "cjafig", "acghahiiddbfjecjjcaf",
        "hhhaefiajdiia", "jh", "egch", "ccchcdfhb", "cbahbjhjhi", "ijjjf", "fdf",
        "fedeabahdgebef", "didjfcjhdafgeaeej", "bd", "eegfjcchaeacd", "afea",
        "bidjccjfijchbig", "egecc", "fb", "fcidaibfd", "eceijdhibcadedbj", "egcgbefdcf",
        "ahihachihecfbah", "ag", "jedadjbgf", "ciecbg", "cjdiiejecjbe",
        "ehheggbahfifehef", "hgahbbgee", "eechihcbgjjd", "bgadi", "gg", "jebiedacbbadci",
        "ijbeefadacgeejeghg", "ghedffgd", "cecd", "cfiag", "djegi", "hebahjjcjbjceaegbg",
        "ejecdcjifchibfgaj", "chhcfi", "ediffhjbbb", "dfhafc", "aheeheg",
        "eaeccjccihibfaig", "ieada", "gbcbgajj", "bhbabjdjjacec", "feaedfheafihciac",
        "jji", "jdabggaeddjhag", "ghcicjchfhbjjbfgh", "idefjhfajicdd", "eddjeadiebi",
        "iffhaiaffehhic", "bfeeedejhdhg", "feddbbga", "eb", "addhefadhecjbedhcg",
        "aedfgf", "ghbhahfdadacaadahcdg", "jijbcfjedj", "iefjihgcafdbjgij",
        "ahacbfgjiagcbigcieg", "hefcidbc", "geffd", "iighbeacecbig",
        "agfghehejgiicdfgdbf", "cjdgeh", "chfdhbedg", "ehbibah", "jc", "egaeigheahcc",
        "ggefccagabehdh", "afbbifihffejfdg", "eacag", "gdddaieacfhfhce",
        "hiijicfhhffcfiehh", "ghgcaijhbhih", "hbcgahjbh", "gbifhggffecidjcejh", "fafag",
        "fghbaaehdg", "ic", "adcd", "deedjibf", "ejd", "aajeifh", "fbiaa", "jhdgchgddbd",
        "dedfegefigbcihh", "haciaadejjjgchg", "fjaafda", "fgcffidjha", "bje", "ib",
        "cacfcgfjc", "hhf", "ibhhibejib", "id", "gihbgeedccjcehi", "bceagiaaa",
        "fdffeafjb", "bfafdagjgged", "ecchedfiejhggdebbgaf", "ceaja",
        "digbefcaeijcffejgeii", "edjaidfh", "dgcbgjfadfbdh", "ifhgbffif", "ef",
        "ajifdiadgiajecebbja", "ehejieeabeh", "iacfdeijbdgafjg", "idgggibggbhffefgf",
        "aibede", "bddchdcbc", "idfahhfbajab", "dccdd", "cdcabjfbedbafdj", "didddhdfcd",
        "fdgddfb", "edfaffdajaedg", "jgjbd", "cbdjadgcefdacjebahdg", "dhhfjhjbhehjjfj",
        "iedfgdecghcbifc", "cjef", "gbjifbbjichcdejfc", "gcjhidjcccidgcjg", "cfifdi",
        "gihcgj", "aieegdicbfcbfaciig", "defjageefihgbbifjf", "jcddffhc",
        "fiagiedgfigefj", "gdehbid", "gfbifi", "cfidbbiejgigd", "efbccgjiea",
        "ghjbgeiagf", "ffbhibgj", "afacgbdjggihbadhh", "bgig", "fgga", "diifggchaaiigbj",
        "abiegigfhjdjhadj", "eafabc", "egbejhbc", "jeidhhfcbcdagcja", "hicecebgjabibjgj",
        "gic", "cbgiieffdcdgjgcgf", "bihb", "cjdhdceegdhdj", "biagajcfdeijjbdibfi",
        "hahfbgbfjjcdf", "fhiaggcgecebcbhecdfg", "biiahhfabbb", "jdiaedgehbgdcebgabbh",
        "diaibbgeeedbaifhcja", "aefejibecchaibhifhha", "ejbddjjabjb", "aifa", "agj",
        "hhabggaegajicif", "bi", "ibah", "da", "dfeggaheedd", "bagccffgjfhaihc",
        "eeihdefjdjfgab", "ehaidfihgeaadbeafbb", "jbhgbjhhagi", "ghfijdfjd",
        "aaihhjffhbiehgcjjddf", "fdee", "ajjebaace", "fjgdidhgjheejageach", "eghagd",
        "djajbehifgdbgghjj", "ebhdjahibj", "adafbfjhafd", "jgajcadig", "hcaijehhhhcceag",
        "jhaeafjafghjjbc", "ggdadjgbjcfcecdce", "bbhfhgjhidad", "aahcdhjg", "fbdeheajih",
        "gid", "cdefddhecigbhfijd", "bif", "hf", "hiahedcfdhcgagdjif", "cahfgda",
        "fcafia", "jag", "efjibhigjegg", "beid", "fadbfidjgaaddjfhjd",
        "bafbbdcihbadiacbfgh", "ddgafdij", "fehicbgejdf", "jgbihibjecjf",
        "fifdaghejhffjdjaeaeb", "dejhdggc", "ggehg", "ibbjbddbaigjg", "jhgd", "a",
        "behijbdjdfefceceeib", "jibcege", "fabbhfgddbcbfbjbbia", "iahjiaaaefajejiigf",
        "bg", "egdahebebdagd", "echciejcjggggighfh", "fdjg", "bdehb", "bcjefb",
        "dgefebib", "hdcihhgjeifiiceabg", "idgagaageadgcge", "fbghchddahiccf",
        "jidjhhefichbbfd", "fjjejjg", "hcdjacejfadcbc", "cfigcfjgdddfbdgfdfia",
        "igbijaibejiijdbebc", "dfjcheciffaecjdfg", "eccgcbgbgffcbhd", "je", "aacggic",
        "cdcahdhbj", "afehechbhjgefgeb", "aadia", "abhifdcaaiigaeheg", "biaagjcd",
        "dcbggcjigifhbeceagc", "idigdidhijifbf", "jdfi", "dj", "eejhdji", "cbe", "db",
        "cfaghagjehihdbhb", "ciccabcc", "jhijiccfbbccjajbdfbe", "aajcijbhe",
        "aihedggjcchcae", "ehjeahfeg", "gjeefbcjicfadaicbdbg", "bbbjaejihgbaeadgaiac",
        "ih", "cgffeiiadeghegga", "gfhhfgdccebfjcjcje", "cjhajdhiegacghi", "fdhaejfabacb",
        "ghddccddbfbhieah", "ehaeh", "jeh", "ajejajihhagji", "haj", "edhjjgifcjgg",
        "ieggjhbfhjgcbghdacg", "bhijidfgcaghjibhfj", "hffdbdijhicbf", "ab",
        "fefaiedcbaddgc", "cffie", "jgdbdjgbfe", "bbae", "cfcjcadjdgchbf",
        "jaefibjhaiiehfdjhb", "gdadfai", "caahcgifjfhb", "bjhejjjahghcdchbia", "ehabdi",
        "ghgahccdgbhdbdfia", "ggffcdb", "agahfjjacie", "ifeiiejhdhgdca", "aiedddgjdeaai",
        "biageedeeg", "bfgbdegdhgggchaeehj", "cbcfacbfdhdafdje", "hifeaghjbei", "hbhfi",
        "ad", "cgjfhge", "fdebhbicaiejbceb", "jbhcedghdafjjjdcbgd", "ihecijjd",
        "feeijicddieb", "eh", "baijccdgfeedgeiafejg", "bjjddecijfaicbiiiij",
        "cafcgdggcdihacbdhfi", "fc", "iibafgedhggig", "eigag", "bdigighda", "fifgajfdab",
        "eai", "cjjdeaidbddgbfhcf", "aaahhjfhhjbfdhdggbb", "aggcddijidfajbe",
        "hgbbhacjdiaggfh", "icbhddefgcbbda", "bgh", "dchd", "gbbaajb", "aadfachjghcijh",
        "bdbidagcjgffff", "jaefgh", "jjhiedghei", "dajaijbebjjhagbieci", "jjjihdjeggefg",
        "hdhfjbccdbijghcgij", "ccjjb", "ghcegibbdigfahh", "igafaejdcejcabeabbei",
        "fihhgefihhcg", "gedfaahed", "jffheedecifdhcdhfi", "cijhbajejhag", "eed", "dgch",
        "ggjedbabhfgjfe", "efhcaejffddebg", "fh", "acfgfdbaif", "djeffiieifijgffd",
        "figg", "eeihafdfbddjji", "hghbagjgi", "hjbbjbhabefbca", "hiid", "daheefigbe",
        "gcihgegjidjb", "ehf", "ghdbcgeacafgdcjgjj", "dhecaifgbcafhfbda", "ehdehafaidf",
        "hheagiaafjgfhbcjahci", "jfbdiifgdhb", "iefbbggaafciabdaacg", "fdiaedgefeca",
        "hhiebebf", "hfbebacbfcihcehe", "hgadbg", "egbebdahjcdge", "fbibhfgdcacbafbcj",
        "bc", "igibdh", "daabdbjhhg", "ghcebfjbfedi", "ahhihgh", "gaggd", "ifhdagcidc",
        "gadbfichabgifdg", "ciibaacaejc", "bhbafbaghfjhf", "dedjcjheigedeafjai",
        "gjhgdgf", "ifbehgij", "dbcddhai", "biabbgji", "figbghjjgbbj", "abicebig",
        "jhgcebadjfidhhbhhif", "baahhjhegajfgdf", "hbdjcjjbcajcfchh", "ee", "aibedcfjde",
        "gihdjbbjifbifgbf", "jaedhcfgfj", "bgbhcegdegcbb", "didbdgjbfajejbaji", "fhiaaca",
        "bcjfbjcjiehhhj", "icfcdhjcdfg", "cffbjjdfbchjdj", "igefbdgeecjcfhigfhbd",
        "aahbiaah", "gbfieeggidfigcgih", "dbbfbihehjaggagafcag", "jiccdefheidchdei",
        "hbgg", "bgdec"};
    printResults(words2);
  }

  private static void printResults(String[] words) {
    PalindromePairs pp = new PalindromePairs();
    for (List<Integer> pairs : pp.palindromePairs(words)) {
      System.out.print("[");
      System.out.print(pairs.get(0));
      System.out.print(",");
      System.out.print(pairs.get(1));
      System.out.print("]");
    }
    System.out.println();
    System.out.println();
  }
}
