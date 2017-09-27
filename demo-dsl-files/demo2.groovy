job('demo2') {
  
  configure { project ->
      
    project / 'publishers' << 'jenkins.plugins.hipchat.HipChatNotifier' {
      credentialId() 
      room('some_room_name')
      notifications {
        'jenkins.plugins.hipchat.model.NotificationConfig' {
          notifyEnabled(true)
          textFormat(true)
          notificationType(FAILURE)
          color(RED)
          messageTemplate()
        }
      }
    }
  }
}