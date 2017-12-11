// Dieses Beispiel wurde aktualisiert um auf "keyup event" zu reagieren 
// als auf "keypress" (letzte Zeile, bei addEventListener). Somit ist neuer Text 
// in <textarea> erst drin bei Loslassen der Taste
var el;                                                    // Declariert Variable

function charCount(e) {                                    // Declariert Funktion
    var textEntered, charDisplay, counter, lastkey;          // Declariert Variable
    textEntered = document.getElementById('message').value;  // Text des Benutzers
    charDisplay = document.getElementById('charactersLeft'); // Zählerelement
    counter = (180 - (textEntered.length));                  // Verbleibende Zeichen
    charDisplay.textContent = counter;                      // Zeigt verbleibende Anzahl an

    lastkey = document.getElementById('lastKey');            // Ruft letzte Taste ab
    lastkey.textContent = 'ASCII-Code des letzten Zeichens: ' + e.keyCode;
    // Meldung zusammenstellen
}
el = document.getElementById('message');                   // Ruft Meldungselement ab
el.addEventListener('keyup', charCount, false); // on keyup Ereignis charCount() Aufruf



// $(document).ready(function () {
//     $("#image_show").bind("click",function () {
//         $("#imgUpload").click();
//     })
//     $("#imgUpload").change(function(e) {
//         for (var i = 0; i < e.target.files.length; i++) {
//             var file = e.target.files.item(i);
//             var freader = new FileReader();
//             freader.readAsDataURL(file);
//             freader.onload = function(e) {
//                 var src = e.target.result;
//                 $("#image_show").attr("src",src);
//             }
//                $("#circle_image").css("background-color","#000000")
//         }
//     })
// })