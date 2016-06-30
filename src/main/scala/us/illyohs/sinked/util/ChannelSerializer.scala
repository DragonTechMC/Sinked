package us.illyohs.sinked.util

import com.google.common.reflect.TypeToken
import ninja.leaping.configurate.ConfigurationNode
import ninja.leaping.configurate.objectmapping.ObjectMappingException
import ninja.leaping.configurate.objectmapping.serialize.TypeSerializer

object ChannelSerializer extends TypeSerializer[Channel] {

  @throws[ObjectMappingException]
  override def deserialize(ty: TypeToken[_], value: ConfigurationNode): Channel = {

  }

  @throws[ObjectMappingException]
  override def serialize(ty: TypeToken[_], obj: Channel, value: ConfigurationNode): Unit = {

  }

}
