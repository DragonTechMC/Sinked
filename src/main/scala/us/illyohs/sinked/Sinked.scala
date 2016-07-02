/**
  * Copyright (c) 2016, Anthony Anderson(Illyohs)
  * All rights reserved.
  *
  *  Redistribution and use in source and binary forms, with or without
  *  modification, are permitted provided that the following conditions are met:
  *
  * * Redistributions of source code must retain the above copyright notice, this
  *   list of conditions and the following disclaimer.
  *
  * * Redistributions in binary form must reproduce the above copyright notice,
  *   this list of conditions and the following disclaimer in the documentation
  *   and/or other materials provided with the distribution.
  *
  * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
  * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
  * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
  * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
  * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
  * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
  * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
  * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
  * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
  * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
  */

package us.illyohs.sinked

import java.io.{File, FileWriter, IOException, Writer}
import java.util

import us.illyohs.sinked.channel.Channel
import us.illyohs.sinked.helper.PluginInfo._

import com.google.gson.{FieldNamingPolicy, Gson, GsonBuilder}
import com.google.inject.Inject
import org.slf4j.Logger
import org.spongepowered.api.event.Listener
import org.spongepowered.api.event.game.state._
import org.spongepowered.api.plugin.Plugin

@Plugin(
  id = ID,
  name = NAME,
  version = VERSION,
  description = DESCRIPTION,
  authors = Array("Anthony Anderson(Illyohs)")
)
class Sinked {

  val chanList:util.List[Channel] = new  util.ArrayList[Channel]()
  val channelDir = new File("./channels/")
  val configDir  = new File("./config/sinked")

  @Inject
  private val logger: Logger = null

  @Listener
  def serverStarting(e:GameStartingServerEvent): Unit = {

  }

  @Listener
  def serverStarted(e:GameStartedServerEvent): Unit = {

  }

  @Listener
  def preInit(e:GamePreInitializationEvent): Unit = {
    addChannel(new GlobalChannel)
    addChannel(new LocalChannel)
    if (!channelDir.exists()) {
      logger.warn("Channel directory not found!")
      logger.info("Now creating new channel directory.")
      channelDir.mkdir()
      createDefualtjons
    }
  }

  @Listener
  def init(e:GameInitializationEvent): Unit = {

//    getLogger.info("Found channel: "+ chanList.get(0).getName)

  }

  @Listener
  def postInit(e:GamePostInitializationEvent): Unit = {

  }

  def createDefualtjons: Unit = {
    val gson:Gson = new GsonBuilder()
      .setPrettyPrinting()
      .serializeNulls()
      .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
      .create()
    for (i <- 0 to 1){
      val ch = chanList.get(i)
      val json = gson.toJson(ch)
      val w:Writer = new FileWriter("./channels/" + ch.getName + ".josn")
      try {
        w.write(json)
        w.close()
      } catch {
        case e:IOException => e.printStackTrace()
      }
    }

  }

  def addChannel(ch:Channel) = chanList.add(ch)

  def getLogger: Logger = this.logger
}

case class GlobalChannel() extends Channel("Global", "", "G", "", "",true, false, false, true)
case class LocalChannel() extends Channel("Local", "", "L", "", "", true, false, false, false)