package com.example.assignment1

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.assignment1.ui.theme.Assignment1Theme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.io.InputStream
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import java.util.*
import kotlin.random.Random
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import kotlinx.coroutines.selects.select

class GuessTheFlag : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RandomFlag() // Display the RandomFlag composable
        }
    }
}

@Composable
fun RandomFlag(){

    // List of flag resource IDs
    val flagResourceIds = listOf(
        R.drawable.ad, R.drawable.ae, R.drawable.af, R.drawable.ag, R.drawable.ai,
        R.drawable.al, R.drawable.am, R.drawable.ao, R.drawable.aq, R.drawable.ar,
        R.drawable.as_, R.drawable.at, R.drawable.au, R.drawable.aw, R.drawable.ax,
        R.drawable.az, R.drawable.ba, R.drawable.bb, R.drawable.bd, R.drawable.be,
        R.drawable.bf, R.drawable.bg, R.drawable.bh, R.drawable.bi, R.drawable.bj,
        R.drawable.bl, R.drawable.bm, R.drawable.bn, R.drawable.bo, R.drawable.bq,
        R.drawable.br, R.drawable.bs, R.drawable.bt, R.drawable.bv, R.drawable.bw,
        R.drawable.by, R.drawable.bz, R.drawable.ca, R.drawable.cc, R.drawable.cd,
        R.drawable.cf, R.drawable.cg, R.drawable.ch, R.drawable.ci, R.drawable.ck,
        R.drawable.cl, R.drawable.cm, R.drawable.cn, R.drawable.co, R.drawable.cr,
        R.drawable.cu, R.drawable.cv, R.drawable.cw, R.drawable.cx, R.drawable.cy,
        R.drawable.cz, R.drawable.de, R.drawable.dj, R.drawable.dk, R.drawable.dm,
        R.drawable.do_, R.drawable.dz, R.drawable.ec, R.drawable.ee, R.drawable.eg,
        R.drawable.eh, R.drawable.er, R.drawable.es, R.drawable.et, R.drawable.eu,
        R.drawable.fi, R.drawable.fj, R.drawable.fk, R.drawable.fm, R.drawable.fo,
        R.drawable.fr, R.drawable.ga, R.drawable.gb_eng, R.drawable.gb_nir,
        R.drawable.gb_sct, R.drawable.gb_wls, R.drawable.gb, R.drawable.gd,
        R.drawable.ge, R.drawable.gf, R.drawable.gg, R.drawable.gh, R.drawable.gi,
        R.drawable.gl, R.drawable.gm, R.drawable.gn, R.drawable.gp, R.drawable.gq,
        R.drawable.gr, R.drawable.gs, R.drawable.gt, R.drawable.gu, R.drawable.gw,
        R.drawable.gy, R.drawable.hk, R.drawable.hm, R.drawable.hn, R.drawable.hr,
        R.drawable.ht, R.drawable.hu, R.drawable.id, R.drawable.ie, R.drawable.il,
        R.drawable.im, R.drawable.in_, R.drawable.io, R.drawable.iq, R.drawable.ir,
        R.drawable.is_, R.drawable.it, R.drawable.je, R.drawable.jm, R.drawable.jo,
        R.drawable.jp, R.drawable.ke, R.drawable.kg, R.drawable.kh, R.drawable.ki,
        R.drawable.km, R.drawable.kn, R.drawable.kp, R.drawable.kr, R.drawable.kw,
        R.drawable.ky, R.drawable.kz, R.drawable.la, R.drawable.lb, R.drawable.lc,
        R.drawable.li, R.drawable.lk, R.drawable.lr, R.drawable.ls, R.drawable.lt,
        R.drawable.lu, R.drawable.lv, R.drawable.ly, R.drawable.ma, R.drawable.mc,
        R.drawable.md, R.drawable.me, R.drawable.mf, R.drawable.mg, R.drawable.mh,
        R.drawable.mk, R.drawable.ml, R.drawable.mm, R.drawable.mn, R.drawable.mo,
        R.drawable.mp, R.drawable.mq, R.drawable.mr, R.drawable.ms, R.drawable.mt,
        R.drawable.mu, R.drawable.mv, R.drawable.mw, R.drawable.mx, R.drawable.my,
        R.drawable.mz, R.drawable.na, R.drawable.nc, R.drawable.ne, R.drawable.nf,
        R.drawable.ng, R.drawable.ni, R.drawable.nl, R.drawable.no, R.drawable.np,
        R.drawable.nr, R.drawable.nu, R.drawable.nz, R.drawable.om, R.drawable.pa,
        R.drawable.pe, R.drawable.pf, R.drawable.pg, R.drawable.ph, R.drawable.pk,
        R.drawable.pl, R.drawable.pm, R.drawable.pn, R.drawable.pr, R.drawable.ps,
        R.drawable.pt, R.drawable.pw, R.drawable.py, R.drawable.qa, R.drawable.re,
        R.drawable.ro, R.drawable.rs, R.drawable.ru, R.drawable.rw, R.drawable.sa,
        R.drawable.sb, R.drawable.sc, R.drawable.sd, R.drawable.se, R.drawable.sg,
        R.drawable.sh, R.drawable.si, R.drawable.sj, R.drawable.sk, R.drawable.sl,
        R.drawable.sm, R.drawable.sn, R.drawable.so, R.drawable.sr, R.drawable.ss,
        R.drawable.st, R.drawable.sv, R.drawable.sx, R.drawable.sy, R.drawable.sz,
        R.drawable.tc, R.drawable.td, R.drawable.tf, R.drawable.tg, R.drawable.th,
        R.drawable.tj, R.drawable.tk, R.drawable.tl, R.drawable.tm, R.drawable.tn,
        R.drawable.to, R.drawable.tr, R.drawable.tt, R.drawable.tv, R.drawable.tw,
        R.drawable.tz, R.drawable.ua, R.drawable.ug, R.drawable.um, R.drawable.us,
        R.drawable.uy, R.drawable.uz, R.drawable.va, R.drawable.vc, R.drawable.ve,
        R.drawable.vg, R.drawable.vi, R.drawable.vn, R.drawable.vu, R.drawable.wf,
        R.drawable.ws, R.drawable.xk, R.drawable.ye, R.drawable.yt, R.drawable.za,
        R.drawable.zm, R.drawable.zw
    )

    // Map of country codes and Names
    val countryMap = mapOf(
        "AD" to "Andorra",
        "AE" to "United Arab Emirates",
        "AF" to "Afghanistan",
        "AG" to "Antigua and Barbuda",
        "AI" to "Anguilla",
        "AL" to "Albania",
        "AM" to "Armenia",
        "AO" to "Angola",
        "AQ" to "Antarctica",
        "AR" to "Argentina",
        "AS" to "American Samoa",
        "AT" to "Austria",
        "AU" to "Australia",
        "AW" to "Aruba",
        "AX" to "Åland Islands",
        "AZ" to "Azerbaijan",
        "BA" to "Bosnia and Herzegovina",
        "BB" to "Barbados",
        "BD" to "Bangladesh",
        "BE" to "Belgium",
        "BF" to "Burkina Faso",
        "BG" to "Bulgaria",
        "BH" to "Bahrain",
        "BI" to "Burundi",
        "BJ" to "Benin",
        "BL" to "Saint Barthélemy",
        "BM" to "Bermuda",
        "BN" to "Brunei Darussalam",
        "BO" to "Bolivia, Plurinational State of",
        "BQ" to "Caribbean Netherlands",
        "BR" to "Brazil",
        "BS" to "Bahamas",
        "BT" to "Bhutan",
        "BV" to "Bouvet Island",
        "BW" to "Botswana",
        "BY" to "Belarus",
        "BZ" to "Belize",
        "CA" to "Canada",
        "CC" to "Cocos (Keeling) Islands",
        "CD" to "Congo, the Democratic Republic of the",
        "CF" to "Central African Republic",
        "CG" to "Republic of the Congo",
        "CH" to "Switzerland",
        "CI" to "Côte d'Ivoire",
        "CK" to "Cook Islands",
        "CL" to "Chile",
        "CM" to "Cameroon",
        "CN" to "China (People's Republic of China)",
        "CO" to "Colombia",
        "CR" to "Costa Rica",
        "CU" to "Cuba",
        "CV" to "Cape Verde",
        "CW" to "Curaçao",
        "CX" to "Christmas Island",
        "CY" to "Cyprus",
        "CZ" to "Czech Republic",
        "DE" to "Germany",
        "DJ" to "Djibouti",
        "DK" to "Denmark",
        "DM" to "Dominica",
        "DO" to "Dominican Republic",
        "DZ" to "Algeria",
        "EC" to "Ecuador",
        "EE" to "Estonia",
        "EG" to "Egypt",
        "EH" to "Western Sahara",
        "ER" to "Eritrea",
        "ES" to "Spain",
        "ET" to "Ethiopia",
        "EU" to "Europe",
        "FI" to "Finland",
        "FJ" to "Fiji",
        "FK" to "Falkland Islands (Malvinas)",
        "FM" to "Micronesia, Federated States of",
        "FO" to "Faroe Islands",
        "FR" to "France",
        "GA" to "Gabon",
        "GB-ENG" to "England",
        "GB-NIR" to "Northern Ireland",
        "GB-SCT" to "Scotland",
        "GB-WLS" to "Wales",
        "GB" to "United Kingdom",
        "GD" to "Grenada",
        "GE" to "Georgia",
        "GF" to "French Guiana",
        "GG" to "Guernsey",
        "GH" to "Ghana",
        "GI" to "Gibraltar",
        "GL" to "Greenland",
        "GM" to "Gambia",
        "GN" to "Guinea",
        "GP" to "Guadeloupe",
        "GQ" to "Equatorial Guinea",
        "GR" to "Greece",
        "GS" to "South Georgia and the South Sandwich Islands",
        "GT" to "Guatemala",
        "GU" to "Guam",
        "GW" to "Guinea-Bissau",
        "GY" to "Guyana",
        "HK" to "Hong Kong",
        "HM" to "Heard Island and McDonald Islands",
        "HN" to "Honduras",
        "HR" to "Croatia",
        "HT" to "Haiti",
        "HU" to "Hungary",
        "ID" to "Indonesia",
        "IE" to "Ireland",
        "IL" to "Israel",
        "IM" to "Isle of Man",
        "IN" to "India",
        "IO" to "British Indian Ocean Territory",
        "IQ" to "Iraq",
        "IR" to "Iran, Islamic Republic of",
        "IS" to "Iceland",
        "IT" to "Italy",
        "JE" to "Jersey",
        "JM" to "Jamaica",
        "JO" to "Jordan",
        "JP" to "Japan",
        "KE" to "Kenya",
        "KG" to "Kyrgyzstan",
        "KH" to "Cambodia",
        "KI" to "Kiribati",
        "KM" to "Comoros",
        "KN" to "Saint Kitts and Nevis",
        "KP" to "Korea, Democratic People's Republic of",
        "KR" to "Korea, Republic of",
        "KW" to "Kuwait",
        "KY" to "Cayman Islands",
        "KZ" to "Kazakhstan",
        "LA" to "Laos (Lao People's Democratic Republic)",
        "LB" to "Lebanon",
        "LC" to "Saint Lucia",
        "LI" to "Liechtenstein",
        "LK" to "Sri Lanka",
        "LR" to "Liberia",
        "LS" to "Lesotho",
        "LT" to "Lithuania",
        "LU" to "Luxembourg",
        "LV" to "Latvia",
        "LY" to "Libya",
        "MA" to "Morocco",
        "MC" to "Monaco",
        "MD" to "Moldova, Republic of",
        "ME" to "Montenegro",
        "MF" to "Saint Martin",
        "MG" to "Madagascar",
        "MH" to "Marshall Islands",
        "MK" to "North Macedonia",
        "ML" to "Mali",
        "MM" to "Myanmar",
        "MN" to "Mongolia",
        "MO" to "Macao",
        "MP" to "Northern Mariana Islands",
        "MQ" to "Martinique",
        "MR" to "Mauritania",
        "MS" to "Montserrat",
        "MT" to "Malta",
        "MU" to "Mauritius",
        "MV" to "Maldives",
        "MW" to "Malawi",
        "MX" to "Mexico",
        "MY" to "Malaysia",
        "MZ" to "Mozambique",
        "NA" to "Namibia",
        "NC" to "New Caledonia",
        "NE" to "Niger",
        "NF" to "Norfolk Island",
        "NG" to "Nigeria",
        "NI" to "Nicaragua",
        "NL" to "Netherlands",
        "NO" to "Norway",
        "NP" to "Nepal",
        "NR" to "Nauru",
        "NU" to "Niue",
        "NZ" to "New Zealand",
        "OM" to "Oman",
        "PA" to "Panama",
        "PE" to "Peru",
        "PF" to "French Polynesia",
        "PG" to "Papua New Guinea",
        "PH" to "Philippines",
        "PK" to "Pakistan",
        "PL" to "Poland",
        "PM" to "Saint Pierre and Miquelon",
        "PN" to "Pitcairn",
        "PR" to "Puerto Rico",
        "PS" to "Palestine",
        "PT" to "Portugal",
        "PW" to "Palau",
        "PY" to "Paraguay",
        "QA" to "Qatar",
        "RE" to "Réunion",
        "RO" to "Romania",
        "RS" to "Serbia",
        "RU" to "Russian Federation",
        "RW" to "Rwanda",
        "SA" to "Saudi Arabia",
        "SB" to "Solomon Islands",
        "SC" to "Seychelles",
        "SD" to "Sudan",
        "SE" to "Sweden",
        "SG" to "Singapore",
        "SH" to "Saint Helena, Ascension and Tristan da Cunha",
        "SI" to "Slovenia",
        "SJ" to "Svalbard and Jan Mayen Islands",
        "SK" to "Slovakia",
        "SL" to "Sierra Leone",
        "SM" to "San Marino",
        "SN" to "Senegal",
        "SO" to "Somalia",
        "SR" to "Suriname",
        "SS" to "South Sudan",
        "ST" to "Sao Tome and Principe",
        "SV" to "El Salvador",
        "SX" to "Sint Maarten (Dutch part)",
        "SY" to "Syrian Arab Republic",
        "SZ" to "Swaziland",
        "TC" to "Turks and Caicos Islands",
        "TD" to "Chad",
        "TF" to "French Southern Territories",
        "TG" to "Togo",
        "TH" to "Thailand",
        "TJ" to "Tajikistan",
        "TK" to "Tokelau",
        "TL" to "Timor-Leste",
        "TM" to "Turkmenistan",
        "TN" to "Tunisia",
        "TO" to "Tonga",
        "TR" to "Turkey",
        "TT" to "Trinidad and Tobago",
        "TV" to "Tuvalu",
        "TW" to "Taiwan (Republic of China)",
        "TZ" to "Tanzania, United Republic of",
        "UA" to "Ukraine",
        "UG" to "Uganda",
        "UM" to "US Minor Outlying Islands",
        "US" to "United States",
        "UY" to "Uruguay",
        "UZ" to "Uzbekistan",
        "VA" to "Holy See (Vatican City State)",
        "VC" to "Saint Vincent and the Grenadines",
        "VE" to "Venezuela, Bolivarian Republic of",
        "VG" to "Virgin Islands, British",
        "VI" to "Virgin Islands, U.S.",
        "VN" to "Vietnam",
        "VU" to "Vanuatu",
        "WF" to "Wallis and Futuna Islands",
        "WS" to "Samoa",
        "XK" to "Kosovo",
        "YE" to "Yemen",
        "YT" to "Mayotte",
        "ZA" to "South Africa",
        "ZM" to "Zambia",
        "ZW" to "Zimbabwe"
    )


    // State to hold the current generated country code
    var randomCountryKey by rememberSaveable {mutableStateOf("")} // Using rememberSaveable function to retain and manage state across configuration changes such as screen rotation

    // Generating a random index

    var randomIndex by rememberSaveable {mutableStateOf(Random.nextInt(0,flagResourceIds.size))}

    // State to track the selected country
    var selectedCountry by rememberSaveable { mutableStateOf("") }

    // State to track if the selected country is correct
    var isCorrect by rememberSaveable { mutableStateOf(false) }

    // State to to track the status of the submit button
    var submitted by rememberSaveable { mutableStateOf(false) }

    // Get the painter for the randomly selected flag
    var randomImagePainter: Painter = painterResource(id = flagResourceIds[randomIndex])

    /*val orientation = LocalConfiguration.current.orientation

    if (orientation == 1)*/

    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "GUESS THE COUNTRY NAME!")

        // Container to display the randomly selected flag
        Box(
            modifier = Modifier.size(180.dp),
            contentAlignment = Alignment.Center
            ){
            Image( // Display the flag
                painter = randomImagePainter,
                contentDescription = "Random Flag",
                modifier = Modifier
                    .size(180.dp)
                    .clip(shape = RoundedCornerShape(5.dp))
            )
        }

        // Display the list of country names
        LazyColumn(
            modifier = Modifier
                .height(400.dp)
                .fillMaxWidth()
                .padding(horizontal = 16.dp)

        ){
            items(countryMap.values.toList()){countryName ->
                Text(
                    text = countryName,
                    modifier = Modifier
                        .padding(vertical = 4.dp)
                        .clickable {
                            if (!submitted) { // Select the country if not submitted
                                selectedCountry = countryName
                            }
                        }
                )
            }
        }



        // Button to reset the game and go to the next flag
        Button(onClick = {
            randomIndex = Random.nextInt(0, flagResourceIds.size)
            randomCountryKey = countryMap.keys.toList()[randomIndex]
            isCorrect = false
            submitted = false
            selectedCountry = ""
        },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text(text = "Next Flag")

        }

        // Button to submit the selected country
        if (selectedCountry.isNotEmpty() && !submitted) {
            Button(
                onClick = {
                    isCorrect = countryMap[randomCountryKey] == selectedCountry
                    submitted = true
                },
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text("Submit")
            }
        }

        // Display the result based on the user input
        if (submitted){
            val message = if (isCorrect) "CORRECT!" else "WRONG! Correct Country: ${countryMap[randomCountryKey]}" // Display Correct or Wrong messages accordingly
            // Define the color of the message based on correctness
            val color = if (isCorrect) Color.Green else Color.Red
            val correctCountryMessage = "Correct Country: ${countryMap[randomCountryKey]}"
            // Build an AnnotatedString to allow for styled text
            Text(
                text = AnnotatedString.Builder(message)
                    .apply {
                        // If the guess is incorrect, style the correct country message to highlight it
                        if (!isCorrect) {
                            addStyle(
                                style = SpanStyle(color = Color.Blue),
                                // Specify the range of the correct country message within the full message
                                start = message.indexOf(correctCountryMessage),
                                end = message.indexOf(correctCountryMessage) + correctCountryMessage.length
                            )
                        }
                    }
                    .toAnnotatedString(),
                color = color,
                modifier = Modifier.padding(top = 16.dp)
            )
            /*Text(
                text = if(isCorrect) "CORRECT!" else "WRONG! Correct Country: ${countryMap[randomCountryKey]}",
                color = if(isCorrect) Color.Green else Color.Red,
                modifier = Modifier.padding(top = 16.dp)

            )*/
        }
    }
}


