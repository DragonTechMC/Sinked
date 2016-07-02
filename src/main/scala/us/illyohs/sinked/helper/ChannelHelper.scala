/**
  * Copyright (c) 2016, Anthony Anderson(Illyohs)
  * All rights reserved.
  *
  * Redistribution and use in source and binary forms, with or without
  * modification, are permitted provided that the following conditions are met:
  *
  * * Redistributions of source code must retain the above copyright notice, this
  * list of conditions and the following disclaimer.
  *
  * * Redistributions in binary form must reproduce the above copyright notice,
  * this list of conditions and the following disclaimer in the documentation
  * and/or other materials provided with the distribution.
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
package us.illyohs.sinked.helper

import java.io.{File, FileWriter, IOException, Writer}
import java.util

import com.google.gson.{FieldNamingPolicy, Gson, GsonBuilder}
import org.spongepowered.api.Sponge
import us.illyohs.sinked.Sinked
import us.illyohs.sinked.channel.Channel

object ChannelHelper {

  val chanList:util.List[Channel] = new  util.ArrayList[Channel]()

  val sinked:Sinked = null
  val channelPath = "./channels/"

  val channelDir = new File(channelPath)

  def initChannel: Unit = {
    chanList.add(new GlobalChannel)
    chanList.add(new LocalChannel)
    if (!channelDir.exists()) {
      //      sinked.getLogger.warn("Channel directory not found!")
      //      sinked.getLogger.info("Now creating channel directory")

      channelDir.mkdir()
      val gson: Gson = new GsonBuilder()
        .setPrettyPrinting()
        .serializeNulls()
        .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
        .create()
      for (i <- 0 to 1) {
        val ch = chanList.get(i)
        val json = gson.toJson(ch)
        val w: Writer = new FileWriter(channelPath + ch.getName + ".json")
        try {
          w.write(json)
          w.close()
          //          sinked.getLogger.info("Created default channel: " +ch.getName)
        } catch {
          case e: IOException => e.printStackTrace()
        }
      }
      //      createDefualtjons
    }
  }


  case class GlobalChannel() extends Channel("Global", "", "G", "", "", false, true, false, false, true)
  case class LocalChannel() extends Channel("Local", "", "L", "", "", false, true, false, false, false)
}


