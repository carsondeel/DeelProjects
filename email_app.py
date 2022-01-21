import smtplib
from email.message import EmailMessage

EmailAdd = "carson.deel@gmail.com"
#senders Gmail id over here
Pass = ""
#senders Gmail 's Password over here

msg = EmailMessage()
msg['Subject'] = 'Subject of the Email'
# Subject of Email
msg['From'] = EmailAdd
msg['To'] = 'carso@email.unc.edu'
# Reciver of the Mail
msg.set_content('Mail Body') # Email body or Content


with smtplib.SMTP_SSL('smtp.gmail.com', 465) as smtp: #Added Gmails SMTP Server
    smtp.login(EmailAdd, Pass) #This command Login SMTP Library using your GMAIL
    smtp.send_message(msg) #This Sends the message