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
    private lateinit var absender: EditText

    // --------------------------------------------------------
    // Wie wird bei den verschiedenen Städten eine Demonstration angemeldet
    // --------------------------------------------------------
    private lateinit var stadt : Array<String>
    private lateinit var stadtdaten : Array<String>


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
        banner = findViewById(R.id.bannerSwitch)
        fahnen = findViewById(R.id.fahnenSwitch)
        megaphone = findViewById(R.id.megaphoneSwitch)
        lautsprecher = findViewById(R.id.lautsprecheranlageSwitch)
        lautsprecherwagen = findViewById(R.id.lautsprecherwagenSwitch)
        absender = findViewById(R.id.absenderText)
        stadtdaten = arrayOf(
            "Aachen (email),poststelle.aachen@polizei.nrw.de",
            "Augsburg (email),Versammlungsrecht@augsburg.de",
            "Berlin (web),https://www.internetwache-polizei-berlin.de/index_2.html",
            "Bielefeld (email),poststelle.bielefeld@polizei.nrw.de",
            "Bochum (email),za.sg12.bochum@polizei.nrw.de",
            "Bonn (email),ZA12.Bonn@polizei.nrw.de",
            "Braunschweig (email),Versammlung@braunschweig.de",
            "Bremen (email),oeffentlicheordnung@ordnungsamt.bremen.de",
            "Chemnitz (email),ordnungsamt@stadt-chemnitz.de",
            "Dortmund (email),poststelle.dortmund@polizei.nrw.de",
            "Dresden (web),https://eforms.dresden.de/intelliform/forms/buergeraccount/buergeraccount-kunde/anwendungen/A32%20Anzeige%20einer%20Versammlung/index",
            "Erfurt (email),buergeramt@erfurt.de",
            "Essen (email),ZA12Versammlungsrecht.Essen@polizei.nrw.de",
            "Freiberg im Breisgau (web),https://formulare.freiburg.de/metaform/Form-Solutions/sid/assistant/5d77cd8ee4b0f2d58d3e4fe9",
            "Gelasenkirchen (email),poststelle.gelsenkirchen@polizei.nrw.de",
            "Halle (Salle) (email),ordnungsamt@saalekreis.de",
            "Duisburg (email),poststelle.duisburg@polizei.nrw.de",
            "Düsseldorf (email),poststelle.duesseldorf@polizei.nrw.de",
            "Frankfurt am Main (email),demo@stadt-frankfurt.de",
            "Hagen (email),poststelle.hagen@polizei.nrw.de",
            "Hamburg (email),lagezentrum@polizei.hamburg.de",
            "Hamm (email),za12.hamm@polizei.nrw.de",
            "Hannover (email),versammlungsrecht@pd-h.polizei.niedersachsen.de",
            "Heidelberg (web),https://formulare.virtuelles-rathaus.de/forms/frm/6n5C9Kp7Jg5HFJdGXhRJfgnHQGt1FJP",
            "Karlsruhe (web),https://formulare.karlsruhe.de/metaform/Form-Solutions/sid/assistant/580ddb490cf22f42356adbd5",
            "Kassel (web),https://www.kassel.de/formulare/1/form000106.php",
            "Kiel (email),ordnungsamt@kiel.de",
            "Krefeld (email),versammlungsrecht.krefeld@polizei.nrw.de",
            "Köln (web),ZA12Versammlungen.koeln@polizei.nrw.de",
            "Leipzig (email),ordnungsamt@leipzig.de",
            "Leverkusen (email),ZA12Versammlungen.koeln@polizei.nrw.de",
            "Ludwigshafen am Rhein (web),https://www.formulare-zidkor.de/forms/findform?shortname=anm_vers&formtecid=2&areashortname=ludwigshafen",
            "Lübeck (email),ordnungsamt@luebeck.de",
            "Mainz (email),zkv-demo@stadt.mainz.de",
            "Magdeburg (email),versammlungsbehoerde.pi-md@polizei.sachsen-anhalt.de",
            "Mannheim (email),31versammlungen@mannheim.de",
            "München (email),versammlungen.kvr@muenchen.de",
            "Münster (email),ZA1.2Versammlungsrecht.Muenster@polizei.nrw.de",
            "Mönchengladbach (email),Poststelle.Moenchengladbach@polizei.nrw.de",
            "Nürnberg (web),https://online-service2.nuernberg.de/intelliform/forms/n/320_oa/320_oa_d_anzeigeversammlung/index",
            "Oberhausen (email),Versammlungsrecht.Oberhausen@Polizei.NRW.de",
            "Oldenburg (email),Ulrike.Boyens@oldenburg-kreis.de",
            "Osnabrück (web),https://service.osnabrueck.de/anmeldung?redirect=https://service.osnabrueck.de/dienstleistungen/-/egov-bis-detail/dienstleistung/26095/show",
            "Potzdam (web),https://polizei.brandenburg.de/onlineservice/versammlung_anmelden",
            "Rostock (web),https://rathaus.rostock.de/de/service/dienstleistungen/versammlung_anmelden/250112",
            "Saarbrücken (email),ordnungsamt@saarbruecken.de",
            "Solingen (email),poststelle.wuppertal@polizei.nrw.de",
            "Stuttgart (email),demonstration@stuttgart.de",
            "Wiesbaden (web),https://www.wiesbaden.de/rathaus/virtuelle-verwaltung/formulare/online-forms/anmeldung-oeffentliche-versammlung.php",
            "Wuppertal (email),poststelle.wuppertal@polizei.nrw.de"
        )
    }

    private fun sendmessage() {
        var betreff = "Versammlungsanzeige für den "
        betreff += versammlungsdatum.text.toString()

        var nachricht = "Sehr geehrte Damen und Herren,\n\n"
        nachricht += "hiermit kündige ich eine Versammlung unter freiem Himmal am "
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
            nachricht += "Folgende Route ist geplant:\n"
            nachricht += route.text.toString()
        } else {
            nachricht += "Die Versammlung wird nur am Versammlungsort stattfinden."
        }
        // Checken ob Versammlungsmittel benötigt werden.
        var mittel = ""
        if (anzahltische.length() > 0) {
            mittel += anzahltische.text.toString()
            mittel += " Infostische.\n"
        }
        if (flyer.isChecked) {
            mittel += "Flyer\n"
        }
        if (banner.isChecked) {
            mittel += "Spruchbänder / Banner\n"
        }
        if (fahnen.isChecked) {
            mittel += "Fahnen"
        }
        if (mittel.length > 3) {
            nachricht += "\nFolgende Versammlungsmittel werden bei der Versammlung verwendet.\n"
            nachricht += mittel
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
        val work :String = stadtdaten[which].substringAfterLast(",")
        if(!work.contains("http",false)) {
            amtemail.setText(work)
            amtemail.requestFocus()
            islink = false
            linkanmeldung = ""
        }
        else {
            amtemail.setText("")
            amtemail.requestFocus()
            islink = true
            linkanmeldung = work
        }
    }

    private fun auswahl() {
        stadt = arrayOf()
        for(s in stadtdaten) {
            stadt = stadt.plus(s.substringBefore(","))
        }
        val builder = AlertDialog.Builder(this)
        val which: Int = -1
        builder.setTitle("In welcher Stadt wird demonstriert?")
        builder.setSingleChoiceItems(stadt,which, ausgewaehlt())

        builder.setNegativeButton("Meine Stadt fehlt") { _, _ ->
            // Wenn eine Stadt Fehlt einen Bug Report auf Github eröffnen
            val intent = Intent()
            intent.action = Intent.ACTION_VIEW
            intent.data = Uri.parse("https://github.com/monomo111/DemoAnmeldenEinfachgemacht/issues")
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