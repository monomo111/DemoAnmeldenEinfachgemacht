package tk.monomo.demoanmeldeneinfachgemacht

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.widget.SwitchCompat
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private lateinit var debugtext : TextView
    private lateinit var sendeButton : Button

    // --------------------------------------------------------
    // Versammlungsleitung
    // --------------------------------------------------------
    private lateinit var versammlungsleitung : CheckBox
    private lateinit var vorname: EditText
    private lateinit var vornamecheckbox : CheckBox
    private var vornamecheck : Boolean = false
    private lateinit var nachname : EditText
    private lateinit var nachnamecheckbox : CheckBox
    private var nachnamecheck : Boolean = false
    private lateinit var strasse : EditText
    private lateinit var strassecheckbox : CheckBox
    private var strassecheck : Boolean = false
    private lateinit var plz : EditText
    private lateinit var plzcheckbox : CheckBox
    private var plzcheck : Boolean = false
    private lateinit var ort : EditText
    private lateinit var ortcheckbox : CheckBox
    private var ortcheck : Boolean = false
    private lateinit var telefon : EditText
    private lateinit var telefoncheckbox : CheckBox
    private var telefoncheck : Boolean = false

    // --------------------------------------------------------
    // Funktion um das Häckchen beim Versammlungsleiter zu setzen
    // --------------------------------------------------------
    private fun checkVersammlungsleitung() {
        if(vornamecheck && nachnamecheck && strassecheck && plzcheck && ortcheck && telefoncheck) {
            versammlungsleitung.setChecked(true)
        }
        else {
            versammlungsleitung.setChecked(false)
        }
    }

    // --------------------------------------------------------
    // Angaben zur Versammlung
    // --------------------------------------------------------
    private lateinit var angabenversammlung : CheckBox
    private lateinit var versammlungsname : EditText
    private lateinit var versammlungsnamecheckbox : CheckBox
    private var versammlungsnamecheck : Boolean = false
    private lateinit var versammlungsort : EditText
    private lateinit var versammlungsortcheckbox : CheckBox
    private var versammlungsortcheck : Boolean = false
    private lateinit var teilnehmerzahl : EditText
    private lateinit var teilnehmerzahlcheckbox : CheckBox
    private var teilnehmerzahlcheck : Boolean = false
    private lateinit var versammlungsdatum : EditText
    private lateinit var versammlungsdatumcheckbox : CheckBox
    private var versammlungsdatumcheck : Boolean = false
    private lateinit var versammlungsbegin : EditText
    private lateinit var versammlungsbegincheckbox : CheckBox
    private var versammlungsbegincheck : Boolean = false
    private lateinit var versammlungsende : EditText
    private lateinit var versammlungsendecheckbox : CheckBox
    private var versammlungsendecheck : Boolean = false

    // --------------------------------------------------------
    // Funktion um das Häckchen bei den Angaben zur Versammlung zu setzen
    // --------------------------------------------------------
    private fun checkangabenversammlung() {
        if(versammlungsnamecheck && versammlungsortcheck && teilnehmerzahlcheck && versammlungsdatumcheck &&
            versammlungsbegincheck && versammlungsendecheck) {
            angabenversammlung.setChecked(true)
        }
        else {
            angabenversammlung.setChecked(false)
        }
    }

    // --------------------------------------------------------
    // Angaben zum Ablauf
    // --------------------------------------------------------
    private lateinit var ablaufcheckbox : CheckBox
    private lateinit var beschreibung : EditText
    private var beschreibungcheck : Boolean = false
    private lateinit var route : EditText
    private lateinit var amtemail : EditText
    private lateinit var amtemailcheckbox : CheckBox
    private var amtemailcheck : Boolean = false

    // --------------------------------------------------------
    // Funktion um das Häckchen beim Ablauf der Versammlung zu setzen
    // --------------------------------------------------------
    private fun checkablauf() {
        if(beschreibungcheck && amtemailcheck) {
            ablaufcheckbox.setChecked(true)
        }
        else {
            ablaufcheckbox.setChecked(false)
        }
    }

    // --------------------------------------------------------
    // Versammlungsmittel
    // --------------------------------------------------------
    private lateinit var anzahltische : EditText
    private lateinit var flyer : SwitchCompat
    private lateinit var banner : SwitchCompat
    private lateinit var fahnen : SwitchCompat
    private lateinit var megaphone : SwitchCompat
    private lateinit var lautsprecher : SwitchCompat
    private lateinit var lautsprecherwagen : SwitchCompat

    // --------------------------------------------------------
    // Was ist das denn alles was wir da so haben
    // --------------------------------------------------------
    private fun init() {
        debugtext   = findViewById(R.id.debugeditText)
        sendeButton = findViewById(R.id.sendbutton)
        vorname     = findViewById(R.id.vornameeditText)
        vornamecheckbox = findViewById(R.id.vornamecheckBox)
        versammlungsleitung = findViewById(R.id.versammlungsleitungcheckBox)
        vorname.setOnFocusChangeListener { _, _ ->
            if(vorname.length() > 1) {
                vornamecheckbox.setChecked(true)
                vornamecheck = true
            }
            else {
                vornamecheckbox.setChecked(false)
                vornamecheck = false
            }
            checkVersammlungsleitung()
        }
        nachname = findViewById(R.id.nachnameText)
        nachnamecheckbox = findViewById(R.id.nachnamecheckBox)
        nachname.setOnFocusChangeListener { _, _ ->
            if(nachname.length() > 1) {
                nachnamecheckbox.setChecked(true)
                nachnamecheck = true
            }
            else {
                nachnamecheckbox.setChecked(false)
                nachnamecheck = false
            }
            checkVersammlungsleitung()
        }
        strasse = findViewById(R.id.strasseText)
        strassecheckbox = findViewById(R.id.straßecheckBox)
        strasse.setOnFocusChangeListener { _, _ ->
            if(strasse.length() > 5) {
                strassecheckbox.setChecked(true)
                strassecheck = true
            }
            else {
                strassecheckbox.setChecked(false)
                strassecheck = false
            }
            checkVersammlungsleitung()
        }
        plz = findViewById(R.id.plzText)
        plzcheckbox = findViewById(R.id.plzcheckBox)
        plz.setOnFocusChangeListener { _, _ ->
            if(plz.length() == 5) {
                plzcheckbox.setChecked(true)
                plzcheck = true
            }
            else {
                plzcheckbox.setChecked(false)
                plzcheck = false
            }
            checkVersammlungsleitung()
        }
        ort = findViewById(R.id.ortText)
        ortcheckbox = findViewById(R.id.ortcheckBox)
        ort.setOnFocusChangeListener { _, _ ->
            if(ort.length() > 2) {
                ortcheckbox.setChecked(true)
                ortcheck = true
            }
            else {
                ortcheckbox.setChecked(false)
                ortcheck = false
            }
            checkVersammlungsleitung()
        }
        telefon = findViewById(R.id.telefonText)
        telefoncheckbox = findViewById(R.id.telefoncheckBox)
        telefon.setOnFocusChangeListener { _, _ ->
            if(telefon.length() >6) {
                telefoncheckbox.setChecked(true)
                telefoncheck = true
            }
            else {
                telefoncheckbox.setChecked(false)
                telefoncheck = false
            }
            checkVersammlungsleitung()
        }
        angabenversammlung = findViewById(R.id.angabencheckBox)
        versammlungsname = findViewById(R.id.versammlungsnameText)
        versammlungsnamecheckbox = findViewById(R.id.versammlungsnamecheckBox)
        versammlungsname.setOnFocusChangeListener { _, _ ->
            if(versammlungsname.length() >5) {
                versammlungsnamecheckbox.setChecked(true)
                versammlungsnamecheck = true
            }
            else {
                versammlungsnamecheckbox.setChecked(false)
                versammlungsnamecheck = false
            }
            checkangabenversammlung()
        }
        versammlungsort = findViewById(R.id.versammlungsortText)
        versammlungsortcheckbox = findViewById(R.id.versammlungsortcheckBox)
        versammlungsort.setOnFocusChangeListener { _, _ ->
            if(versammlungsort.length() >2) {
                versammlungsortcheckbox.setChecked(true)
                versammlungsortcheck = true
            }
            else {
                versammlungsortcheckbox.setChecked(false)
                versammlungsortcheck = false
            }
            checkangabenversammlung()
        }
        teilnehmerzahl = findViewById(R.id.teilnehmerzahlText)
        teilnehmerzahlcheckbox = findViewById(R.id.teilnehmerzahlcheckBox)
        teilnehmerzahl.setOnFocusChangeListener { _, _ ->
            if(teilnehmerzahl.length() >0) {
                teilnehmerzahlcheckbox.setChecked(true)
                teilnehmerzahlcheck = true
            }
            else {
                teilnehmerzahlcheckbox.setChecked(false)
                teilnehmerzahlcheck = false
            }
            checkangabenversammlung()
        }

        versammlungsdatum = findViewById(R.id.versammlungsdatumText)
        versammlungsdatumcheckbox = findViewById(R.id.versammlungsdatumcheckBox)
        versammlungsdatum.setOnFocusChangeListener { _, _ ->
            if(versammlungsdatum.length() >5) {
                versammlungsdatumcheckbox.setChecked(true)
                versammlungsdatumcheck = true
            }
            else {
                versammlungsdatumcheckbox.setChecked(false)
                versammlungsdatumcheck = false
            }
            checkangabenversammlung()
        }
        versammlungsbegin = findViewById(R.id.versammlungsbeginText)
        versammlungsbegincheckbox = findViewById(R.id.versammlungsbegincheckBox)
        versammlungsbegin.setOnFocusChangeListener { _, _ ->
            if(versammlungsbegin.length() >3) {
                versammlungsbegincheckbox.setChecked(true)
                versammlungsbegincheck = true
            }
            else {
                versammlungsbegincheckbox.setChecked(false)
                versammlungsbegincheck = false
            }
            checkangabenversammlung()
        }
        versammlungsende = findViewById(R.id.versammlungsendeText)
        versammlungsendecheckbox = findViewById(R.id.versammlungsendecheckBox)
        versammlungsende.setOnFocusChangeListener { _, _ ->
            if(versammlungsende.length() >3) {
                versammlungsendecheckbox.setChecked(true)
                versammlungsendecheck = true
            }
            else {
                versammlungsendecheckbox.setChecked(false)
                versammlungsendecheck = false
            }
            checkangabenversammlung()
        }
        ablaufcheckbox = findViewById(R.id.ablaufcheckBox)
        beschreibung = findViewById(R.id.beschreibungsText)
        beschreibung.setOnFocusChangeListener { _, _ ->
            if(beschreibung.length() > 10) {
                beschreibungcheck = true
            }
            else {
                beschreibungcheck = false
            }
            checkablauf()
        }
        route = findViewById(R.id.routeText)
        amtemail = findViewById(R.id.emailamtText)
        amtemailcheckbox = findViewById(R.id.emailamtcheckBox)
        amtemail.setOnFocusChangeListener { _, _ ->
            if(amtemail.length() >5) {
                amtemailcheck = true
                amtemailcheckbox.setChecked(true)
            }
            else {
                amtemailcheckbox.setChecked(false)
                amtemailcheck = false
            }
            checkablauf()
        }
        anzahltische = findViewById(R.id.anzahltischeText)
        flyer = findViewById(R.id.flyerSwitch)
        banner = findViewById(R.id.bannerSwitch)
        fahnen = findViewById(R.id.fahnenSwitch)
        megaphone = findViewById(R.id.megaphoneSwitch)
        lautsprecher = findViewById(R.id.lautsprecheranlageSwitch)
        lautsprecherwagen = findViewById(R.id.lautsprecherwagenSwitch)
    }
    private fun sendmessage()  {
        var nachricht : String
        nachricht = "Sehr geehrte Damen und Herren,\n\n"
        nachricht += " hiermit kündige ich "
        nachricht += vorname.text.toString()
        nachricht += " "
        //nachricht += nachname.text.toString()
        //if(flyer_checked == true) nachricht += " Flyer"
        debugtext.setText(nachricht)
        /*val intent = Intent(Intent.ACTION_SEND)
        val adresse = arrayOf("monomo@gmx.net")
        intent.putExtra(Intent.EXTRA_EMAIL,adresse)
        intent.putExtra(Intent.EXTRA_SUBJECT, "Test")
        intent.putExtra(Intent.EXTRA_TEXT,nachricht)
        startActivity(Intent.createChooser(intent, "Send Email using:"))
         */
    }
    private fun checkinput() : Boolean {
        if(vornamecheck == false) {
            vorname.setHint(R.string.vorname_fehlt)
            vorname.requestFocus()
            return false
        }
        if(nachnamecheck == false){
            nachname.setHint(R.string.nachname_fehlt)
            nachname.requestFocus()
            return false
        }
        if(strassecheck == false) {
            strasse.setHint(R.string.stra_e_hausnummer_fehlt)
            strasse.requestFocus()
            return false
        }
        if(plzcheck == false) {
            plz.setHint(R.string.postleitzahl_feht)
            plz.requestFocus()
            return false
        }
        if(ortcheck == false) {
            ort.setHint(R.string.ort_fehlt)
            ort.requestFocus()
            return false
        }
        if(telefoncheck == false) {
            telefon.setHint(R.string.telefonnummer_fehlt)
            telefon.requestFocus()
            return false
        }
        if(versammlungsnamecheck == false) {
            versammlungsname.setHint(R.string.name_der_versammlung_fehlt)
            versammlungsname.requestFocus()
            return false
        }
        if(versammlungsortcheck == false) {
            versammlungsort.setHint(R.string.versammlungsort_fehlt)
            versammlungsort.requestFocus()
            return false
        }
        if(teilnehmerzahlcheck == false) {
            teilnehmerzahl.setHint(R.string.erwartete_teilnehmerzahl_fehlt)
            teilnehmerzahl.requestFocus()
            return false
        }
        if(versammlungsdatumcheck == false) {
            versammlungsdatum.setHint(R.string.datum_der_versammlung_fehlt)
            versammlungsdatum.requestFocus()
            return false
        }
        if(versammlungsbegincheck == false) {
            versammlungsbegin.setHint(R.string.beginn_der_versammlung_fehlt)
            versammlungsbegin.requestFocus()
            return false
        }
        if(versammlungsendecheck == false) {
            versammlungsende.setHint(R.string.ende_der_versammlung_fehlt)
            versammlungsende.requestFocus()
            return false
        }
        if(beschreibungcheck == false) {
            beschreibung.setHint(R.string.beschreibung_des_ablaufs_der_versammlung_was_ist_geplant_fehlt)
            beschreibung.requestFocus()
            return false
        }
        if(amtemailcheck == false) {
            amtemail.setHint(R.string.emailadresse_anmeldebeh_rde_fehlt)
            amtemail.requestFocus()
            return false
        }
        return true
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        sendeButton.setOnClickListener(){
            if(checkinput() == true) {
                sendmessage()
            }
            else {
                sendeButton.setText(R.string.abschicken_fehler)
            }

        }


    }
}