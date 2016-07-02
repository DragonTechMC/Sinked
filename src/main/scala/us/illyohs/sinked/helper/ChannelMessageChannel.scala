package us.illyohs.sinked.helper

import java.util

import org.spongepowered.api.text.channel.{MessageChannel, MessageReceiver}

object ChannelMessageChannel
  extends MessageChannel {

  override def getMembers: util.Collection[MessageReceiver] = ???
}
