package fifthstar;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class BiggerIsGreaterTest {

    List<String> values = Arrays.asList(
            "imllmmcslslkyoegymoa",
            "fvincndjrurfh",
            "rtglgzzqxnuflitnlyit",
            "mhtvaqofxtyrz",
            "zalqxykemvzzgaka",
            "wjjulziszbqqdcpdnhdo",
            "japjbvjlxzkgietkm",
            "jqczvgqywydkunmjw",
            "ehdegnmorgafrjxvksc",
            "tydwixlwghlmqo",
            "wddnwjneaxbwhwamr",
            "pnimbesirfbivxl",
            "mijamkzpiiniveik",
            "qxtwpdpwexuej",
            "qtcshorwyck",
            "xoojiggdcyjrupr",
            "vcjmvngcdyabcmjz",
            "xildrrhpca",
            "rrcntnbqchsfhvijh",
            "kmotatmrabtcomu",
            "bnfcejmyotvw",
            "dnppdkpywiaxddoqx",
            "tmowsxkrodmkkra",
            "jfkaehlegohwggf",
            "ttylsiegnttymtyx",
            "kyetllczuyibdkwyihrq",
            "xdhqbvlbtmmtshefjf",
            "kpdpzzohihzwgdfzgb",
            "kuywptftapaa",
            "qfqpegznnyludrv",
            "ufwogufbzaboaepslikq",
            "jfejqapjvbdcxtkry",
            "sypjbvatgidyxodd",
            "wdpfyqjcpcn",
            "baabpjckkytudr",
            "uvwurzjyzbhcqmrypraq",
            "kvtwtmqygksbim",
            "ivsjycnooeodwpt",
            "zqyxjnnitzawipqsm",
            "blmrzavodtfzyepz",
            "bmqlhqndacv",
            "phvauobwkrcfwdecsd",
            "vpygyqubqywkndhpzw",
            "yikanhdrjxw",
            "vnpblfxmvwkflqobrk",
            "pserilwzxwyorldsxksl",
            "qymbqaehnyzhfqpqprpl",
            "fcakwzuqlzglnibqmkd",
            "jkscckttaeifiksgkmxx",
            "dkbllravwnhhfjjrce",
            "imzsyrykfvjt",
            "tvogoocldlukwfcajvix",
            "cvnagtypozljpragvlj",
            "hwcmacxvmus",
            "rhrzcpprqccf",
            "clppxvwtaktchqrdif",
            "qwusnlldnolhq",
            "yitveovrja",
            "arciyxaxtvmfgquwb",
            "pzbxvxdjuuvuv",
            "nxfowilpdxwlpt",
            "swzsaynxbytytqtq",
            "qyrogefleeyt",
            "iotjgthvslvmjpcchhuf",
            "knfpyjtzfq",
            "tmtbfayantmwk",
            "asxwzygngwn",
            "rmwiwrurubt",
            "bhmpfwhgqfcqfldlhs",
            "yhbidtewpgp",
            "jwwbeuiklpodvzii",
            "anjhprmkwibe",
            "lpwhqaebmr",
            "dunecynelymcpyonjq",
            "hblfldireuivzekegit",
            "uryygzpwifrricwvge",
            "kzuhaysegaxtwqtvx",
            "kvarmrbpoxxujhvgpw",
            "hanhaggqzdpunkugzmhq",
            "gnwqwsylqeuqr",
            "qzkjbnyvclrkmdtc",
            "argsnaqbquv",
            "obbnlkoaklcx",
            "ojiilqieycsasvqosycu",
            "qhlgiwsmtxbffjsxt",
            "vvrvnmndeogyp",
            "ibeqzyeuvfzb",
            "sajpyegttujxyx",
            "zmdjphzogfldlkgbchnt",
            "tbanvjmwirxx",
            "gmdhdlmopzyvddeqyjja",
            "yxvmvedubzcpd",
            "soygdzhbckfuk",
            "gkbekyrhcwc",
            "wevzqpnqwtpfu",
            "rbobquotbysufwqjeo",
            "bpgqfwoyntuhkvwo",
            "schtabphairewhfmp",
            "rlmrahlisggguykeu",
            "fjtfrmlqvsekq");

    List<String> expected = Arrays.asList("imllmmcslslkyoegyoam",
            "fvincndjrurhf",
            "rtglgzzqxnuflitnlyti",
            "mhtvaqofxtyzr",
            "zalqxykemvzzgkaa",
            "wjjulziszbqqdcpdnhod",
            "japjbvjlxzkgietmk",
            "jqczvgqywydkunmwj",
            "ehdegnmorgafrjxvsck",
            "tydwixlwghlomq",
            "wddnwjneaxbwhwarm",
            "pnimbesirfbixlv",
            "mijamkzpiiniveki",
            "qxtwpdpwexuje",
            "qtcshorwykc",
            "xoojiggdcyjrurp",
            "vcjmvngcdyabcmzj",
            "xildrrpach",
            "rrcntnbqchsfhvjhi",
            "kmotatmrabtcoum",
            "bnfcejmyotwv",
            "dnppdkpywiaxddoxq",
            "tmowsxkrodmkrak",
            "jfkaehlegowfggh",
            "ttylsiegnttymxty",
            "kyetllczuyibdkwyiqhr",
            "xdhqbvlbtmmtshejff",
            "kpdpzzohihzwgdgbfz",
            "kuywptftpaaa",
            "qfqpegznnyludvr",
            "ufwogufbzaboaepsliqk",
            "jfejqapjvbdcxtkyr",
            "sypjbvatgiodddxy",
            "wdpfyqjcpnc",
            "baabpjckkyturd",
            "uvwurzjyzbhcqmryprqa",
            "kvtwtmqygksbmi",
            "ivsjycnooeodwtp",
            "zqyxjnnitzawipsmq",
            "blmrzavodtfzyezp",
            "bmqlhqndavc",
            "phvauobwkrcfwdedcs",
            "vpygyqubqywkndhwpz",
            "yikanhdrwjx",
            "vnpblfxmvwkflqokbr",
            "pserilwzxwyorldsxlks",
            "qymbqaehnyzhfqpqrlpp",
            "fcakwzuqlzglnidbkmq",
            "jkscckttaeifiksgkxmx",
            "dkbllravwnhhfjjrec",
            "imzsyrykfvtj",
            "tvogoocldlukwfcajvxi",
            "cvnagtypozljprajglv",
            "hwcmacxvsmu",
            "rhrzcpprqcfc",
            "clppxvwtaktchqrfdi",
            "qwusnlldnolqh",
            "yitverajov",
            "arciyxaxtvmfgqwbu",
            "pzbxvxdjuuvvu",
            "nxfowilpdxwltp",
            "swzsaynxbytyttqq",
            "qyrogefletey",
            "iotjgthvslvmjpcchufh",
            "knfpyjtzqf",
            "tmtbfayantwkm",
            "asxwzygnngw",
            "rmwiwrurutb",
            "bhmpfwhgqfcqfldlsh",
            "yhbidtewppg",
            "jwwbeuiklpodziiv",
            "anjhprmkwieb",
            "lpwhqaebrm",
            "dunecynelymcpyonqj",
            "hblfldireuivzekegti",
            "uryygzpwifrriecgvw",
            "kzuhaysegaxtwqtxv",
            "kvarmrbpoxxujhvgwp",
            "hanhaggqzdpunkugzmqh",
            "gnwqwsylqeurq",
            "qzkjbnyvclrkmtcd",
            "argsnaqbqvu",
            "obbnlkoaklxc",
            "ojiilqieycsasvqosyuc",
            "qhlgiwsmtxbffjtsx",
            "vvrvnmndeopgy",
            "ibeqzyeuvzbf",
            "sajpyegttujyxx",
            "zmdjphzogfldlkgbchtn",
            "tbanvjmwixrx",
            "gmdhdlmopzyvddeyajjq",
            "yxvmvedubzdcp",
            "soygdzhbckkfu",
            "gkbekyrhwcc",
            "wevzqpnqwtpuf",
            "rbobquotbysufwqjoe",
            "bpgqfwoyntuhkwov",
            "schtabphairewhfpm",
            "rlmrahlisggguykue",
            "fjtfrmlqvseqk");

    @Test
    public void testBiggerIsGreater() {
        List<String> actual = values.stream().map(BiggerIsGreater::biggerIsGreater).collect(Collectors.toList());
        for (int i = 0; i < actual.size(); i++) {
            assertEquals("for " + values.get(i), expected.get(i), actual.get(i));
        }
    }

}
