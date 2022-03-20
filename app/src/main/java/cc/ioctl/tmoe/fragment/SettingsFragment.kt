package cc.ioctl.tmoe.fragment

import android.widget.Toast
import cc.ioctl.tmoe.R
import cc.ioctl.tmoe.hook.func.*
import cc.ioctl.tmoe.ui.LocaleController
import cc.ioctl.tmoe.ui.dsl.BaseHierarchyFragment
import cc.ioctl.tmoe.ui.dsl.HierarchyDescription

class SettingsFragment : BaseHierarchyFragment() {
    override val hierarchy = HierarchyDescription(
        titleKey = "TMoeSettings",
        titleResId = R.string.TMoeSettings,
    ) {
        category("BasicFunction", R.string.BasicFunction) {
            functionSwitch(
                EnableDebugMode.INSTANCE, "EnableDebugMode", R.string.EnableDebugMode
            )
            functionSwitch(
                AntiAntiForward, "AntiAntiForward", R.string.AntiAntiForward
            )
            functionSwitch(
                HideSponsoredMsg, "HideSponsoredMsg", R.string.HideSponsoredMsg
            )
            functionSwitch(
                HideUserAvatar.INSTANCE, "HideUserAvatar", R.string.HideUserAvatar,
                descProvider = {
                    if (HideUserAvatar.INSTANCE.isEnabledByUser) {
                        LocaleController.formatString(
                            "HideUserAvatarEnabledTargetCount",
                            R.string.HideUserAvatarEnabledTargetCount,
                            HideUserAvatar.INSTANCE.selectedUserCount,
                            HideUserAvatar.INSTANCE.selectedChannelCount,
                            HideUserAvatar.INSTANCE.selectedGroupCount
                        )
                    } else {
                        LocaleController.getString("NotEnabled", R.string.NotEnabled)
                    }
                },
                onClick = {
                    Toast.makeText(
                        context,
                        LocaleController.getString("NotImplemented", R.string.NotImplemented),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            )

            functionSwitch(
                AntiAntiCopy, "AntiAntiCopy",  R.string.AntiAntiCopy,
                descProvider ={
                    LocaleController.getString("AntiAntiCopyD", R.string.AntiAntiCopyD)
                }
            )
            functionSwitch(
                ProhibitSpoilers, "ProhibitSpoilers",  R.string.ProhibitSpoilers
            )
            functionSwitch(
                HistoricalNewsOption, "HistoricalNewsOption",  R.string.HistoricalNewsOption
            )
            functionSwitch(
                ProhibitChannelSwitching, "ProhibitChannelSwitching", R.string.ProhibitChannelSwitching
            )
            functionSwitch(
                ProhibitEnableReactions, "ProhibitEnableReactions",  R.string.ProhibitEnableReactions
            )
            functionSwitch(
                ProhibitChatGreetings, "ProhibitChatGreetings",  R.string.ProhibitChatGreetings
            )
            functionSwitch(
                HidePhoneNumber, "HidePhoneNumber",  R.string.HidePhoneNumber
            )
            functionSwitch(
                AddSubItemChannel, "AddSubItemChannel",  R.string.AddSubItemChannel,
                descProvider ={
                    LocaleController.getString("AddSubItemChannelD", R.string.AddSubItemChannelD)
                }
            )
            functionSwitch(
                ChannelDetailNumbers, "ChannelDetailNumbers",  R.string.ChannelDetailNumbers,
                descProvider ={
                    LocaleController.getString("ChannelDetailNumbersD", R.string.ChannelDetailNumbersD)
                }
            )

            functionSwitch(
                AddInfoContainer, "AddInfoContainer",  R.string.AddInfoContainer,
                descProvider ={
                    LocaleController.getString("AddInfoContainerD", R.string.AddInfoContainerD)
                }
            )


        }
        category("About", R.string.About) {
            textValue("AboutTMoe", R.string.AboutTMoe, onClick = {
                presentFragment(AboutFragment())
            })
        }
    }
}
