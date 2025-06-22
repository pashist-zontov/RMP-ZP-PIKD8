package ru.fefu.helloworld

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat


class ActivityPageRegister : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page_register)
        val GoBack: Button = findViewById(R.id.imgBackarr)

        GoBack.setOnClickListener {
            val intent = Intent(this, ActivityPageMain::class.java)
            startActivity(intent)
        }

        val regButton: Button = findViewById(R.id.regButton)
    }

    private fun setupClickableText() {
        val agreementT = findViewById<TextView>(R.id.Agreement)
        val fullText = agreementT.text.toString()
        val spannableString = SpannableString(fullText)

        val purpleColor = ContextCompat.getColor(this, R.color.purple_500)

        val privacyPhrase = "политикой конфиденциальности"
        val termsPhrase = "пользовательское соглашение"

        val privacyStart = fullText.indexOf(privacyPhrase)
        val privacyEnd = privacyStart + privacyPhrase.length

        val termsStart = fullText.indexOf(termsPhrase)
        val termsEnd = termsStart + termsPhrase.length

        val privacyClickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
//                openPrivacyPolicy()
            }

            override fun updateDrawState(ds: TextPaint) {
                ds.color = purpleColor
                ds.isUnderlineText = false
            }
        }

        val termsClickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
//                openUserAgreement()
            }

            override fun updateDrawState(ds: TextPaint) {
                ds.color = purpleColor
                ds.isUnderlineText = false
            }
        }

        spannableString.setSpan(
            privacyClickableSpan,
            privacyStart,
            privacyEnd,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        spannableString.setSpan(
            termsClickableSpan,
            termsStart,
            termsEnd,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        spannableString.setSpan(
            ForegroundColorSpan(purpleColor),
            privacyStart,
            privacyEnd,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        spannableString.setSpan(
            ForegroundColorSpan(purpleColor),
            termsStart,
            termsEnd,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        agreementT.text = spannableString
        agreementT.movementMethod = LinkMovementMethod.getInstance()
        agreementT.highlightColor = Color.TRANSPARENT // Убираем подсветку при клике
    }

//    private fun openPrivacyPolicy() {
//        startActivity(Intent(this, PrivacyPolicyActivity::class.java))
//    }
//
//    private fun openUserAgreement() {
//        startActivity(Intent(this, UserAgreementActivity::class.java))
//    }
}