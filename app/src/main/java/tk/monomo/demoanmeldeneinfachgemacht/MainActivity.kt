
package tk.monomo.demoanmeldeneinfachgemacht

import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat


class MainActivity : AppCompatActivity() {
    private lateinit var sendeButton: Button
    // --------------------------------------------------------
    // Versammlungsleitung
    // --------------------------------------------------------
    private lateinit var versammlungsleitung: CheckBox
    private lateinit var vorname: EditText
    private lateinit var vornamecheckbox: CheckBox
    private var vornamecheck: Boolean = false
    private lateinit var nachname: EditText
    private lateinit var nachnamecheckbox: CheckBox
    private var nachnamecheck: Boolean = false
    private lateinit var strasse: EditText
    private lateinit var strassecheckbox: CheckBox
    private var strassecheck: Boolean = false
    private lateinit var plz: EditText
    private lateinit var plzcheckbox: CheckBox
    private var plzcheck: Boolean = false
    private lateinit var ort: EditText
    private lateinit var ortcheckbox: CheckBox
    private var ortcheck: Boolean = false
    private lateinit var telefon: EditText
    private lateinit var telefoncheckbox: CheckBox
    private var telefoncheck: Boolean = false

    // --------------------------------------------------------
    // Funktion um das Häckchen beim Versammlungsleiter zu setzen
    // --------------------------------------------------------
    private fun checkVersammlungsleitung() {
        versammlungsleitung.isChecked = vornamecheck && nachnamecheck && strassecheck && plzcheck && ortcheck && telefoncheck
    }

    // --------------------------------------------------------
    // Angaben zur Versammlung
    // --------------------------------------------------------
    private lateinit var angabenversammlung: CheckBox
    private lateinit var versammlungsname: EditText
    private lateinit var versammlungsnamecheckbox: CheckBox
    private var versammlungsnamecheck: Boolean = false
    private lateinit var versammlungsort: EditText
    private lateinit var versammlungsortcheckbox: CheckBox
    private var versammlungsortcheck: Boolean = false
    private lateinit var teilnehmerzahl: EditText
    private lateinit var teilnehmerzahlcheckbox: CheckBox
    private var teilnehmerzahlcheck: Boolean = false
    private lateinit var versammlungsdatum: EditText
    private lateinit var versammlungsdatumcheckbox: CheckBox
    private var versammlungsdatumcheck: Boolean = false
    private lateinit var versammlungsbegin: EditText
    private lateinit var versammlungsbegincheckbox: CheckBox
    private var versammlungsbegincheck: Boolean = false
    private lateinit var versammlungsende: EditText
    private lateinit var versammlungsendecheckbox: CheckBox
    private var versammlungsendecheck: Boolean = false

    // --------------------------------------------------------
    // Funktion um das Häckchen bei den Angaben zur Versammlung zu setzen
    // --------------------------------------------------------
    private fun checkangabenversammlung() {
        angabenversammlung.isChecked = versammlungsnamecheck && versammlungsortcheck && teilnehmerzahlcheck && versammlungsdatumcheck &&
                versammlungsbegincheck && versammlungsendecheck
    }

    // --------------------------------------------------------
    // Angaben zum Ablauf
    // --------------------------------------------------------
    private lateinit var ablaufcheckbox: CheckBox
    private lateinit var beschreibung: EditText
    private var beschreibungcheck: Boolean = false
    private lateinit var route: EditText
    private lateinit var ordner: SwitchCompat
    private lateinit var amtemail: EditText
    private lateinit var amtemailcheckbox: CheckBox
    private var amtemailcheck: Boolean = false


    // --------------------------------------------------------
    // Versammlungsmittel
    // --------------------------------------------------------
    private lateinit var anzahltische: EditText
    private lateinit var flyer: SwitchCompat
    private lateinit var banner: SwitchCompat
    private lateinit var fahnen: SwitchCompat
    private lateinit var megaphone: SwitchCompat
    private lateinit var lautsprecher: SwitchCompat
    private lateinit var lautsprecherwagen: SwitchCompat
    private lateinit var buehne: SwitchCompat
    private lateinit var absender: EditText

    // --------------------------------------------------------
    // Wie wird bei den verschiedenen Städten eine Demonstration angemeldet
    // --------------------------------------------------------
    private lateinit var stadt : Array<String>
    private lateinit var stadtdaten : List<Stadtdatenclass>
    private data class Stadtdatenclass(val stadtname: String, val emailamt : String, val webseite :String)

    // --------------------------------------------------------
    // Was ist das denn alles was wir da so haben
    // --------------------------------------------------------
    private fun init() {
        sendeButton = findViewById(R.id.sendbutton)
        vorname = findViewById(R.id.vornameeditText)
        vornamecheckbox = findViewById(R.id.vornamecheckBox)
        versammlungsleitung = findViewById(R.id.versammlungsleitungcheckBox)
        vorname.setOnFocusChangeListener { _, _ ->
            if (vorname.length() > 1) {
                vornamecheckbox.isChecked = true
                vornamecheck = true
            } else {
                vornamecheckbox.isChecked = false
                vornamecheck = false
            }
            checkVersammlungsleitung()
        }
        nachname = findViewById(R.id.nachnameText)
        nachnamecheckbox = findViewById(R.id.nachnamecheckBox)
        nachname.setOnFocusChangeListener { _, _ ->
            if (nachname.length() > 1) {
                nachnamecheckbox.isChecked = true
                nachnamecheck = true
            } else {
                nachnamecheckbox.isChecked = false
                nachnamecheck = false
            }
            checkVersammlungsleitung()
        }
        strasse = findViewById(R.id.strasseText)
        strassecheckbox = findViewById(R.id.straßecheckBox)
        strasse.setOnFocusChangeListener { _, _ ->
            if (strasse.length() > 5) {
                strassecheckbox.isChecked = true
                strassecheck = true
            } else {
                strassecheckbox.isChecked = false
                strassecheck = false
            }
            checkVersammlungsleitung()
        }
        plz = findViewById(R.id.plzText)
        plzcheckbox = findViewById(R.id.plzcheckBox)
        plz.setOnFocusChangeListener { _, _ ->
            if (plz.length() == 5) {
                plzcheckbox.isChecked = true
                plzcheck = true
            } else {
                plzcheckbox.isChecked = false
                plzcheck = false
            }
            checkVersammlungsleitung()
        }
        ort = findViewById(R.id.ortText)
        ortcheckbox = findViewById(R.id.ortcheckBox)
        ort.setOnFocusChangeListener { _, _ ->
            if (ort.length() > 2) {
                ortcheckbox.isChecked = true
                ortcheck = true
            } else {
                ortcheckbox.isChecked = false
                ortcheck = false
            }
            checkVersammlungsleitung()
        }
        telefon = findViewById(R.id.telefonText)
        telefoncheckbox = findViewById(R.id.telefoncheckBox)
        telefon.setOnFocusChangeListener { _, _ ->
            if (telefon.length() > 6) {
                telefoncheckbox.isChecked = true
                telefoncheck = true
            } else {
                telefoncheckbox.isChecked = false
                telefoncheck = false
            }
            checkVersammlungsleitung()
        }
        angabenversammlung = findViewById(R.id.angabencheckBox)
        versammlungsname = findViewById(R.id.versammlungsnameText)
        versammlungsnamecheckbox = findViewById(R.id.versammlungsnamecheckBox)
        versammlungsname.setOnFocusChangeListener { _, _ ->
            if (versammlungsname.length() > 5) {
                versammlungsnamecheckbox.isChecked = true
                versammlungsnamecheck = true
            } else {
                versammlungsnamecheckbox.isChecked = false
                versammlungsnamecheck = false
            }
            checkangabenversammlung()
        }
        versammlungsort = findViewById(R.id.versammlungsortText)
        versammlungsortcheckbox = findViewById(R.id.versammlungsortcheckBox)
        versammlungsort.setOnFocusChangeListener { _, _ ->
            if (versammlungsort.length() > 2) {
                versammlungsortcheckbox.isChecked = true
                versammlungsortcheck = true
            } else {
                versammlungsortcheckbox.isChecked = false
                versammlungsortcheck = false
            }
            checkangabenversammlung()
        }
        teilnehmerzahl = findViewById(R.id.teilnehmerzahlText)
        teilnehmerzahlcheckbox = findViewById(R.id.teilnehmerzahlcheckBox)
        teilnehmerzahl.setOnFocusChangeListener { _, _ ->
            if (teilnehmerzahl.length() > 0) {
                teilnehmerzahlcheckbox.isChecked = true
                teilnehmerzahlcheck = true
            } else {
                teilnehmerzahlcheckbox.isChecked = false
                teilnehmerzahlcheck = false
            }
            checkangabenversammlung()
        }

        versammlungsdatum = findViewById(R.id.versammlungsdatumText)
        versammlungsdatumcheckbox = findViewById(R.id.versammlungsdatumcheckBox)
        versammlungsdatum.setOnFocusChangeListener { _, _ ->
            if (versammlungsdatum.length() > 5) {
                versammlungsdatumcheckbox.isChecked = true
                versammlungsdatumcheck = true
            } else {
                versammlungsdatumcheckbox.isChecked = false
                versammlungsdatumcheck = false
            }
            checkangabenversammlung()
        }
        versammlungsbegin = findViewById(R.id.versammlungsbeginText)
        versammlungsbegincheckbox = findViewById(R.id.versammlungsbegincheckBox)
        versammlungsbegin.setOnFocusChangeListener { _, _ ->
            if (versammlungsbegin.length() > 3) {
                versammlungsbegincheckbox.isChecked = true
                versammlungsbegincheck = true
            } else {
                versammlungsbegincheckbox.isChecked = false
                versammlungsbegincheck = false
            }
            checkangabenversammlung()
        }
        versammlungsende = findViewById(R.id.versammlungsendeText)
        versammlungsendecheckbox = findViewById(R.id.versammlungsendecheckBox)
        versammlungsende.setOnFocusChangeListener { _, _ ->
            if (versammlungsende.length() > 3) {
                versammlungsendecheckbox.isChecked = true
                versammlungsendecheck = true
            } else {
                versammlungsendecheckbox.isChecked = false
                versammlungsendecheck = false
            }
            checkangabenversammlung()
        }
        ablaufcheckbox = findViewById(R.id.ablaufcheckBox)
        beschreibung = findViewById(R.id.beschreibungsText)
        beschreibung.setOnFocusChangeListener { _, _ ->
            if(beschreibung.length() > 10) {
                beschreibungcheck = true
                ablaufcheckbox.isChecked = true
            }
            else {
                beschreibungcheck = false
                ablaufcheckbox.isChecked = false
            }
        }
        route = findViewById(R.id.routeText)
        ordner = findViewById(R.id.ordnerSwitch)
        ordner.setOnClickListener{ordnerauswahl()}
        amtemail = findViewById(R.id.emailamtText)
        amtemailcheckbox = findViewById(R.id.emailamtcheckBox)
        amtemail.setOnFocusChangeListener { _, _ ->
            if (amtemail.length() > 5) {
                amtemailcheck = true
                amtemailcheckbox.isChecked = true
            } else {
                amtemailcheckbox.isChecked = false
                amtemailcheck = false
            }
        }
        anzahltische = findViewById(R.id.anzahltischeText)
        flyer = findViewById(R.id.flyerSwitch)
        flyer.setOnClickListener { auswahlflyer() }
        banner = findViewById(R.id.bannerSwitch)
        banner.setOnClickListener{ auswahlbanner() }
        fahnen = findViewById(R.id.fahnenSwitch)
        fahnen.setOnClickListener{ auswahlfahnen() }
        megaphone = findViewById(R.id.megaphoneSwitch)
        megaphone.setOnClickListener { megaphoneauswahl() }
        lautsprecher = findViewById(R.id.lautsprecheranlageSwitch)
        lautsprecher.setOnClickListener { lautsprecherauswahl() }
        lautsprecherwagen = findViewById(R.id.lautsprecherwagenSwitch)
        lautsprecherwagen.setOnClickListener { lautsprecherwagenauswahl() }
        buehne = findViewById(R.id.buehneSwitch)
        buehne.setOnClickListener { buehneauswahl() }

        absender = findViewById(R.id.absenderText)
        stadtdaten = listOf <Stadtdatenclass> (
            Stadtdatenclass("Aachen (email)","poststelle.aachen@polizei.nrw.de",""),
            Stadtdatenclass("Augsburg (email)","Versammlungsrecht@augsburg.de",""),
            Stadtdatenclass("Bergisch Gladbach (email)","versammlungsrecht.rheinisch-bergischer-kreis@polizei.nrw.de","" ),
            Stadtdatenclass("Berlin (web)","","https://www.internetwache-polizei-berlin.de/index_2.html"),
            Stadtdatenclass("Bielefeld (email)","poststelle.bielefeld@polizei.nrw.de",""),
            Stadtdatenclass("Bochum (email)","za.sg12.bochum@polizei.nrw.de",""),
            Stadtdatenclass("Bonn (email)","ZA12.Bonn@polizei.nrw.de",""),
            Stadtdatenclass("Bottrop (email)","ZA1.2Versammlungsrecht.Muenster@polizei.nrw.de",""),
            Stadtdatenclass("Braunschweig (email)","Versammlung@braunschweig.de",""),
            Stadtdatenclass("Bremen (email)","oeffentlicheordnung@ordnungsamt.bremen.de",""),
            Stadtdatenclass("Bremerhavern (email)","oeffentlicheordnung@ordnungsamt.bremen.de",""),
            Stadtdatenclass("Chemnitz (email)","ordnungsamt@stadt-chemnitz.de",""),
            Stadtdatenclass("Cottbus (web)","","https://polizei.brandenburg.de/onlineservice/versammlung_anmelden"),
            Stadtdatenclass("Dortmund (email)","poststelle.dortmund@polizei.nrw.de",""),
            Stadtdatenclass("Dresden (web)","","https://eforms.dresden.de/intelliform/forms/buergeraccount/buergeraccount-kunde/anwendungen/A32%20Anzeige%20einer%20Versammlung/index"),
            Stadtdatenclass("Duisburg (email)","poststelle.duisburg@polizei.nrw.de",""),
            Stadtdatenclass("Düren (email)","ZA12.Dueren@polizei.nrw.de",""),
            Stadtdatenclass("Düsseldorf (email)","poststelle.duesseldorf@polizei.nrw.de",""),
            Stadtdatenclass("Esslingen (email)","stadt@esslingen.de",""),
            Stadtdatenclass("Erfurt (email)","buergeramt@erfurt.de",""),
            Stadtdatenclass("Erlangen (email)","poststelle@erlangen-hoechstadt.de",""),
            Stadtdatenclass("Essen (email)","ZA12Versammlungsrecht.Essen@polizei.nrw.de",""),
            Stadtdatenclass("Frankfurt am Main (email)","demo@stadt-frankfurt.de",""),
            Stadtdatenclass("Freiberg im Breisgau (web)","","https://formulare.freiburg.de/metaform/Form-Solutions/sid/assistant/5d77cd8ee4b0f2d58d3e4fe9"),
            Stadtdatenclass("Fürth (web)","","https://online-service2.nuernberg.de/intelliform/forms/n/320_oa/320_oa_d_anzeigeversammlung/index"),
            Stadtdatenclass("Gelasenkirchen (email)","poststelle.gelsenkirchen@polizei.nrw.de",""),
            Stadtdatenclass("Gera (email)","versammlungen@gera.de",""),
            Stadtdatenclass("Göttingen (email)","ordnung@goettingen.de",""),
            Stadtdatenclass("Gütersloh (email)","poststelle.guetersloh@polizei.nrw.de",""),
            Stadtdatenclass("Hagen (email)","poststelle.hagen@polizei.nrw.de",""),
            Stadtdatenclass("Halle (Salle) (email)","ordnungsamt@saalekreis.de",""),
            Stadtdatenclass("Hamburg (email)","lagezentrum@polizei.hamburg.de",""),
            Stadtdatenclass("Hamm (email)","za12.hamm@polizei.nrw.de",""),
            Stadtdatenclass("Hanau (email)","Kreisordnung@mkk.de",""),
            Stadtdatenclass("Hannover (email)","versammlungsrecht@pd-h.polizei.niedersachsen.de",""),
            Stadtdatenclass("Heidelberg (email)","versammlungen@heidelberg.de",""),
            Stadtdatenclass("Heilbronn (email)","ordnungsamt@heilbronn.de",""),
            Stadtdatenclass("Herne (email)","za.sg12.bochum@polizei.nrw.de",""),
            Stadtdatenclass("Ingolstadt (web)","","https://www.ingolstadt.de/redirect.phtml?extlink=1&La=1&url_fid=3052.2035.1"),
            Stadtdatenclass("Iserlohn (email)","poststelle.maerkischer-kreis@polizei.nrw.de",""),
            Stadtdatenclass("Jena (email)","versammlungen@jena.de",""),
            Stadtdatenclass("Karlsruhe (web)","","https://formulare.karlsruhe.de/metaform/Form-Solutions/sid/assistant/580ddb490cf22f42356adbd5"),
            Stadtdatenclass("Kassel (web)","","https://www.kassel.de/formulare/1/form000106.php"),
            Stadtdatenclass("Kiel (email)","ordnungsamt@kiel.de",""),
            Stadtdatenclass("Krefeld (email)","versammlungsrecht.krefeld@polizei.nrw.de",""),
            Stadtdatenclass("Koblenz (email)","ordnungsamt@stadt.koblenz.de",""),
            Stadtdatenclass("Köln (email)","ZA12Versammlungen.koeln@polizei.nrw.de",""),
            Stadtdatenclass("Leipzig (email)","ordnungsamt@leipzig.de",""),
            Stadtdatenclass("Leverkusen (email)","ZA12Versammlungen.koeln@polizei.nrw.de",""),
            Stadtdatenclass("Ludwigsburg (email)","rathaus@ludwigsburg.de",""),
            Stadtdatenclass("Ludwigshafen am Rhein (email)","martin.graf@ludwigshafen.de",""),
            Stadtdatenclass("Lübeck (email)","ordnungsamt@luebeck.de",""),
            Stadtdatenclass("Mainz (email)","zkv-demo@stadt.mainz.de",""),
            Stadtdatenclass("Magdeburg (email)","versammlungsbehoerde.pi-md@polizei.sachsen-anhalt.de",""),
            Stadtdatenclass("Mannheim (email)","31versammlungen@mannheim.de",""),
            Stadtdatenclass("München (email)","versammlungen.kvr@muenchen.de",""),
            Stadtdatenclass("Münster (email)","ZA1.2Versammlungsrecht.Muenster@polizei.nrw.de",""),
            Stadtdatenclass("Moers (email)","DirZA.wesel@polizei.nrw.de",""),
            Stadtdatenclass("Mönchengladbach (email)","Poststelle.Moenchengladbach@polizei.nrw.de",""),
            Stadtdatenclass("Neuss (email)","poststelle.rhein-kreis-neuss@polizei.nrw.de",""),
            Stadtdatenclass("Nürnberg (web)","","https://online-service2.nuernberg.de/intelliform/forms/n/320_oa/320_oa_d_anzeigeversammlung/index"),
            Stadtdatenclass("Oberhausen (email)","Versammlungsrecht.Oberhausen@Polizei.NRW.de",""),
            Stadtdatenclass("Offenbach am Main (email)","ordnungsamt@offenbach.de",""),
            Stadtdatenclass("Oldenburg (email)","Ulrike.Boyens@oldenburg-kreis.de",""),
            Stadtdatenclass("Osnabrück (email)","heijmer@osnabrueck.de",""),
            Stadtdatenclass("Paderborn (email)","poststelle.paderborn@polizei.nrw.de",""),
            Stadtdatenclass("Pforzheim (email)","afo@pforzheim.de",""),
            Stadtdatenclass("Potzdam (web)","","https://polizei.brandenburg.de/onlineservice/versammlung_anmelden"),
            Stadtdatenclass("Recklinghausen (email)","versammlungsrecht.recklinghausen@polizei.nrw.de",""),
            Stadtdatenclass("Regensburg (email)","gewerbe-ordnungsamt@lra-regensburg.de",""),
            Stadtdatenclass("Reutlingen (email)","ordnungsamt.verkehrsabteilung@reutlingen.de",""),
            Stadtdatenclass("Remscheid (email)","versammlungsrecht.wuppertal@polizei.nrw.de",""),
            Stadtdatenclass("Saarbrücken (email)","ordnungsamt@saarbruecken.de",""),
            Stadtdatenclass("Salzgitter (web)","","https://formulare.salzgitter.de/sz/32/versammlung.html"),
            Stadtdatenclass("Schwerin (email)","malehmann@schwerin.de",""),
            Stadtdatenclass("Siegen (email)","za.siegen-wittgenstein@polizei.nrw.de",""),
            Stadtdatenclass("Solingen (email)","poststelle.wuppertal@polizei.nrw.de",""),
            Stadtdatenclass("Stuttgart (email)","sicherheit@stuttgart.de",""),
            Stadtdatenclass("Trier (email)","ordnungsamt@trier.de",""),
            Stadtdatenclass("Tübingen (email)","ordnung@tuebingen.de",""),
            Stadtdatenclass("Wiesbaden (web)","","https://www.wiesbaden.de/rathaus/virtuelle-verwaltung/formulare/online-forms/anmeldung-oeffentliche-versammlung.php"),
            Stadtdatenclass("Witten (email)","za.sg12.bochum@polizei.nrw.de",""),
            Stadtdatenclass("Wuppertal (email)","poststelle.wuppertal@polizei.nrw.de",""),
            Stadtdatenclass("Würzburg (email)","versammlungsanzeigen@lra-wue.bayern.de",""),
            Stadtdatenclass("Wolfsburg (email)","servicecenter@stadt.wolfsburg.de",""),
            Stadtdatenclass("Blank Email"," ","")
        )
    }
    private fun ordnerauswahl() {
        if(ordner.isChecked) ordner.setText(R.string.werden_ordner_eingesetzt_ja)
        else ordner.setText(R.string.werden_ordner_eingesetzt)
    }

    private fun auswahlflyer() {
        if(flyer.isChecked) flyer.setText(R.string.flyer_ausgewaehlt)
        else flyer.setText(R.string.flyer)
    }
    private fun auswahlbanner() {
        if(banner.isChecked) banner.setText(R.string.banner_ausgwaehlt)
        else banner.setText(R.string.banner)
    }
    private fun auswahlfahnen () {
        if(fahnen.isChecked) fahnen.setText(R.string.fahnen_ausgewaehlt)
        else fahnen.setText(R.string.fahnen)
    }
    private fun buehneauswahl() {
        if(buehne.isChecked) buehne.setText(R.string.b_hne_ausgewaehlt)
        else buehne.setText(R.string.b_hne)
    }
    private fun lautsprecherauswahl () {
        if(lautsprecher.isChecked) lautsprecher.setText(R.string.lautsprecheranlage_ausgewaehlt)
        else lautsprecher.setText(R.string.lautsprecheranlage)
    }
    private fun lautsprecherwagenauswahl() {
        if(lautsprecherwagen.isChecked) lautsprecherwagen.setText(R.string.lautsprecherwagen_ausgewaehlt)
        else lautsprecherwagen.setText(R.string.lautsprecherwagen)
    }
    private fun megaphoneauswahl() {
        if(megaphone.isChecked) megaphone.setText(R.string.megaphone_ausgewaehlt)
        else megaphone.setText(R.string.megaphone)
    }

    private fun sendmessage() {
        var betreff = "Versammlungsanzeige für den "
        betreff += versammlungsdatum.text.toString()

        var nachricht = "Sehr geehrte Damen und Herren,\n\n"
        nachricht += "hiermit kündige ich eine Versammlung unter freiem Himmel am "
        nachricht += versammlungsdatum.text.toString()
        nachricht += " mit dem Motto \""
        nachricht += versammlungsname.text.toString()
        nachricht += "\" an.\n"
        nachricht += "Versammlungsort: "
        nachricht += versammlungsort.text.toString()
        nachricht += "\nVersammlungsbeginn: "
        nachricht += versammlungsbegin.text.toString()
        nachricht += "\nVersammlungsende: "
        nachricht += versammlungsende.text.toString()
        nachricht += "\n"
        nachricht += "Versammlungsleitung: \n"
        nachricht += vorname.text.toString()
        nachricht += " "
        nachricht += nachname.text.toString()
        nachricht += "\n"
        nachricht += strasse.text.toString()
        nachricht += "\n"
        nachricht += plz.text.toString()
        nachricht += " "
        nachricht += ort.text.toString()
        nachricht += "\nTelefonisch zu erreichen unter: "
        nachricht += telefon.text.toString()
        nachricht += "\n\n"
        nachricht += "Ich erwarte ca. "
        nachricht += teilnehmerzahl.text.toString()
        nachricht += " Teilnehmer bei dieser Versammlung.\n"
        if (ordner.isChecked) {
            nachricht += "Bei der Versammlung werden Ordner zur unterstützung der Versammlungsleitung eingesetzt.\n"
        }
        nachricht += "\n"
        nachricht += "Der Ablauf der Versammlung ist wie folgt geplant:\n"
        nachricht += beschreibung.text.toString()
        nachricht += "\n\n"

        if (route.length() > 3) {
            nachricht += "Folgende Route ist angedacht:\n"
            nachricht += route.text.toString()
            nachricht += "\n"
        } else {
            nachricht += "Die Versammlung wird nur am Versammlungsort statt finden.\n"
        }
        // Checken ob Versammlungsmittel benötigt werden.
        var first : Boolean = true
        var mittelliste =""
        if (anzahltische.length() > 0) {
            mittelliste += anzahltische.text.toString()
            mittelliste += " Infostisch(e)"
            first = false
        }
        if (flyer.isChecked) {
            if(!first)mittelliste += ", "
            mittelliste +="Flyer"
            first = false
        }
        if (banner.isChecked) {
            if(!first)mittelliste += ", "
            mittelliste +="\"Spruchbänder / Banner\""
            first = false
        }
        if (fahnen.isChecked) {
            if(!first)mittelliste += ", "
            mittelliste +="Fahnen"
            first = false
        }
        if(megaphone.isChecked) {
            if(!first)mittelliste += ", "
            mittelliste +="Megaphone"
            first = false
        }
        if(lautsprecher.isChecked) {
            if(!first)mittelliste += ", "
            mittelliste +="Lautsprecheranlage"
            first = false
        }
        if(lautsprecherwagen.isChecked) {
            if(!first)mittelliste += ", "
            mittelliste +="Lautsprecherwagen"
            first = false
        }
        if(buehne.isChecked) {
            if(!first)mittelliste += ", "
            mittelliste +="Bühne"
            first = false
        }
        if (!first) {
            nachricht += "\nFolgende Versammlungsmittel werden bei der Versammlung eingesetzt:\n"
            nachricht += mittelliste
        }

        nachricht += "\n\n"
        nachricht += "Mit freundlichen Grüßen "
        if (absender.length() > 3) {
            nachricht += absender.text.toString()
        } else {
            nachricht += vorname.text.toString()
            nachricht += " "
            nachricht += nachname.text.toString()
        }
        betreff = "Versammlungsanzeige für den "
        betreff += versammlungsdatum.text.toString()
        val intent = Intent(Intent.ACTION_SEND)
        val amtsemail : String =  amtemail.text.toString()
        val adresse = arrayOf(amtsemail)
        intent.putExtra(Intent.EXTRA_EMAIL,adresse)
        intent.putExtra(Intent.EXTRA_SUBJECT,betreff)
        intent.putExtra(Intent.EXTRA_TEXT,nachricht)
        intent.type = "message/rfc822"
        startActivity(Intent.createChooser(intent, "Email senden mit:"))
    }

    private fun checkinput(): Boolean {
        absender.requestFocus()
        if (!vornamecheck) {
            vorname.setHint(R.string.vorname_fehlt)
            vorname.requestFocus()
            return false
        }
        if (!nachnamecheck) {
            nachname.setHint(R.string.nachname_fehlt)
            nachname.requestFocus()
            return false
        }
        if (!strassecheck) {
            strasse.setHint(R.string.stra_e_hausnummer_fehlt)
            strasse.requestFocus()
            return false
        }
        if (!plzcheck) {
            plz.setHint(R.string.postleitzahl_feht)
            plz.requestFocus()
            return false
        }
        if (!ortcheck) {
            ort.setHint(R.string.ort_fehlt)
            ort.requestFocus()
            return false
        }
        if (!telefoncheck) {
            telefon.setHint(R.string.telefonnummer_fehlt)
            telefon.requestFocus()
            return false
        }
        if (!versammlungsnamecheck) {
            versammlungsname.setHint(R.string.name_der_versammlung_fehlt)
            versammlungsname.requestFocus()
            return false
        }
        if (!versammlungsortcheck) {
            versammlungsort.setHint(R.string.versammlungsort_fehlt)
            versammlungsort.requestFocus()
            return false
        }
        if (!teilnehmerzahlcheck) {
            teilnehmerzahl.setHint(R.string.erwartete_teilnehmerzahl_fehlt)
            teilnehmerzahl.requestFocus()
            return false
        }
        if (!versammlungsdatumcheck) {
            versammlungsdatum.setHint(R.string.datum_der_versammlung_fehlt)
            versammlungsdatum.requestFocus()
            return false
        }
        if (!versammlungsbegincheck) {
            versammlungsbegin.setHint(R.string.beginn_der_versammlung_fehlt)
            versammlungsbegin.requestFocus()
            return false
        }
        if (!versammlungsendecheck) {
            versammlungsende.setHint(R.string.ende_der_versammlung_fehlt)
            versammlungsende.requestFocus()
            return false
        }
        if (!beschreibungcheck) {
            beschreibung.setHint(R.string.beschreibung_des_ablaufs_der_versammlung_was_ist_geplant_fehlt)
            beschreibung.requestFocus()
            return false
        }
        if (!amtemailcheck) {
            amtemail.setHint(R.string.emailadresse_anmeldebeh_rde_fehlt)
            amtemail.requestFocus()
            return false
        }
        return true
    }
    private var islink : Boolean = false
    private lateinit var linkanmeldung : String

    private fun ausgewaehlt() = DialogInterface.OnClickListener { _, which ->
        var work :String = stadtdaten[which].emailamt
        if(work.length > 0) {
            amtemail.setText(work)
            amtemail.requestFocus()
            islink = false
            linkanmeldung = ""
        }
        else {
            work = stadtdaten[which].webseite
            amtemail.setText("")
            amtemail.requestFocus()
            islink = true
            linkanmeldung = work
        }
    }

    private fun auswahl() {
        stadt = arrayOf()
        for(s in stadtdaten) {
            stadt = stadt.plus(s.stadtname)
        }
        val builder = AlertDialog.Builder(this)
        val which: Int = -1
        builder.setTitle("In welcher Stadt wird demonstriert?")
        builder.setSingleChoiceItems(stadt,which, ausgewaehlt())

        builder.setNegativeButton("Meine Stadt fehlt") { _, _ ->
            // Wenn eine Stadt fehlt zur Wiki Seite verweisen.
            val intent = Intent()
            intent.action = Intent.ACTION_VIEW
            intent.data = Uri.parse("https://github.com/monomo111/DemoAnmeldenEinfachgemacht/wiki")
            startActivity(intent)
        }
        builder.setPositiveButton("Auswahl übernehmen"){ _,_->
            if(islink) {
                // Wenn die Anmeldung per Webinterface funktioniert direkt die Url öffen
                val intent = Intent()
                intent.action = Intent.ACTION_VIEW
                intent.data = Uri.parse(linkanmeldung)
                startActivity(intent)
            }
            else {
                // Ausfüllen der Daten für die Email starten
                versammlungsleitung.requestFocus()
            }
        }
        builder.show()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        auswahl()
        sendeButton.setOnClickListener{
            if(checkinput()) {
                sendmessage()
            }
            else {
                sendeButton.setText(R.string.abschicken_fehler)
            }
        }
    }
}




